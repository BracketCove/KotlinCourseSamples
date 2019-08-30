package com.wiseassblog.calculator.data

interface IValidator {
    suspend fun validateExpression(expression:String): Boolean
}