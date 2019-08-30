package com.wiseassblog.calculator

import com.wiseassblog.calculator.domain.ICalculator
import com.wiseassblog.calculator.domain.ResultWrapper

class CalculatorFakeImpl : ICalculator {

    var succeed = false

    override suspend fun evaluateExpression(exp: String, callback: (ResultWrapper<Exception, String>) -> Unit) {
        if (succeed) callback.invoke(ResultWrapper.build { "4" })
        else callback.invoke(ResultWrapper.build { throw java.lang.Exception() })
    }

}