package com.wiseassblog.calculator

import com.wiseassblog.calculator.data.CalculatorImpl
import com.wiseassblog.calculator.data.IEvaluator
import com.wiseassblog.calculator.data.IValidator
import com.wiseassblog.calculator.domain.ResultWrapper
import com.wiseassblog.calculator.userinterface.ICalculatorUI
import com.wiseassblog.calculator.userinterface.ViewEvent
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


internal const val VALID_EXPRESSION: String = "2+2"
internal const val VALID_ANSWER: String = "4"
internal const val INVALID_EXPRESSION: String = "2+++"

class CalculatorImplTest {


    private lateinit var calc: CalculatorImpl
    private val validator = ValidatorFakeImpl()
    private val evaluator = EvaluatorFakeImpl()
    private val logicFake = CalculatorLogicFakeImpl()



    /**
     * 1. Give expression to validator: true = valid
     * 2. Give expression to evaluator: String = successful
     * 3. return result
     */
    @Test
    fun `On Evaluate Valid Expression`() = runBlocking {
        calc = CalculatorImpl(validator, evaluator)

        calc.evaluateExpression(VALID_EXPRESSION, logicFake::handleResult)

        val result = logicFake.result
        if (result is ResultWrapper.Success){
            assertEquals(result.value, "4" )
        } else {
            assertTrue(false)
        }
    }

    /**
     * 1. Give expression to validator: false = invalid
     * 2. return result: Exception
     *
     */
    @Test
    fun `On Evaluate invalid Expression`() = runBlocking {
        calc = CalculatorImpl(validator, evaluator)
        evaluator.succeed = false
        calc.evaluateExpression(INVALID_EXPRESSION, logicFake::handleResult)

        val result = logicFake.result
        if (result is ResultWrapper.Error){
            assertTrue(true)
        } else {
            assertTrue(false)
        }
    }
}

class ValidatorFakeImpl : IValidator {
    internal var succeed: Boolean = true
    internal var called: Boolean = false

    override suspend fun validateExpression(expression: String): Boolean {
        called = true
        return succeed
    }

}

class EvaluatorFakeImpl : IEvaluator {
    override suspend fun evaluateExpression(expression: String): ResultWrapper<Exception, String> {
        called = true
        return if (succeed) ResultWrapper.build { VALID_ANSWER }
        else ResultWrapper.build { throw Exception() }
    }

    internal var succeed: Boolean = true
    internal var called: Boolean = false

}

class CalculatorLogicFakeImpl : ICalculatorUI.Logic {

    var viewEventCalled = false
    var handleResultCalled = false
    var result: ResultWrapper<Exception, String>? = null

    override fun handleViewEvent(event: ViewEvent) {
        viewEventCalled = true
    }

    override fun handleResult(result: ResultWrapper<Exception, String>) {
        this.result = result
        handleResultCalled = true
    }
}
