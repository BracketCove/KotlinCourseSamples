package com.wiseassblog.calculator.domain


/**
 * This interface represents the boundary between the front end and back end
 * of the application. It can be thought of as a Facade Pattern, which is very
 * similar to a Repository Pattern.
 */
interface ICalculator {
    suspend fun evaluateExpression(exp: String, callback: (ResultWrapper<Exception, String>) -> Unit)
}