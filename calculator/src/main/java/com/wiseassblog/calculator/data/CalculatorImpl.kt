package com.wiseassblog.calculator.data

import com.wiseassblog.calculator.domain.ICalculator
import com.wiseassblog.calculator.domain.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CalculatorImpl(
    val validator: IValidator,
    val evaluator: IEvaluator
) : ICalculator {
    override suspend fun evaluateExpression(
        exp: String,
        callback: (ResultWrapper<Exception, String>) -> Unit
    ) {
        if (validator.validateExpression(exp)) callback.invoke(evaluator.evaluateExpression(exp))
        else callback.invoke(ResultWrapper.build { throw Exception() })
    }

}