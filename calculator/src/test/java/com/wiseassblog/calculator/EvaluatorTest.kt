package com.wiseassblog.calculator

import com.wiseassblog.calculator.domain.ResultWrapper
import com.wiseassblog.kotlincalculator.data.EvaluatorImpl
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class EvaluatorTest {

    val eval = EvaluatorImpl

    val VALID_EXPRESSION_ONE: String = "2+2"
    val VALID_EXPRESSION_TWO: String = "6*8/6"
    val VALID_EXPRESSION_THREE: String = "6+8/2-7"
    val VALID_ANSWER_ONE: String = "4.0"
    val VALID_ANSWER_TWO: String = "8.0"
    val VALID_ANSWER_THREE: String = "3.0"

    @Test
    fun `Test Valid Expressions`() = runBlocking{
        val resultOne = eval.evaluateExpression(VALID_EXPRESSION_ONE)

        if (resultOne is ResultWrapper.Success){
            Assertions.assertEquals(resultOne.value, VALID_ANSWER_ONE)
        } else {
            Assertions.assertTrue(false)
        }

        val resultTwo = eval.evaluateExpression(VALID_EXPRESSION_TWO)

        if (resultTwo is ResultWrapper.Success){
            Assertions.assertEquals(resultTwo.value, VALID_ANSWER_TWO)
        } else {
            Assertions.assertTrue(false)
        }

    }








}