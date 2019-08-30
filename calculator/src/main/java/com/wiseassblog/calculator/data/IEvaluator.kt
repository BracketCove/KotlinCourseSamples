package com.wiseassblog.calculator.data

import com.wiseassblog.calculator.domain.ResultWrapper

interface IEvaluator {
    suspend fun evaluateExpression(expression: String): ResultWrapper<Exception, String>
}