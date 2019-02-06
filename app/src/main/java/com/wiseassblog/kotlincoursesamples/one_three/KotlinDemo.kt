package com.wiseassblog.kotlindemo

/**
 * Program:
 * Simple Calculator
 *
 * Problem Statement:
 * This program accepts one of the following arguments:
 * - "+"
 * - "-"
 * - "*"
 * - "/"
 *
 * If the first argument of the program matches one of the above Strings [1a], execute the appropriate
 * mathematical function [2a]. Display this result in the console [3a].
 *
 * If the first argument of the program does not match any of the above Strings [1b], display an error
 * message in the console [2b].
 *
 */

/**
 * Constants
 */
val testOperandOne = 5.0
val testOperandTwo = 4.0


val ERROR_MESSAGE = "An error has occured."

val ADD: String = "+"
val SUBTRACT = "-"
val MULTIPLY = "*"
val DIVIDE = "/"

/**
 * Functions (fun) are logical instructions which are executed by devices which can interpret them.
 * fun main(args: Array<String>) is a special function which can be used as the "starting point" for
 * a program's execution. Without a "fun main(...)", our program would have no starting point; and
 *therefore would not do anything useful
 */
fun main(args: Array<String>) {
    //The Program arguments we supply in the command line show up in this reference called "args"

    //args is an "Array", which is a collection of data. To get the first "element" (thing) in the
    //array, we give it index [0]. The "0", refers to the distance from the first element of the
    //array. This is the cause of much confusion and many errors.
    val operatorSymbol = args[0]

    start(operatorSymbol)
}

fun start(operatorSymbol: String) {
    if (checkArguments(operatorSymbol)) displayResult(
        evaluateBinomial(
            testOperandOne,
            testOperandTwo,
            operatorSymbol
        )
    )
    else {
        displayResult(ERROR_MESSAGE)
    }
}

fun displayResult(result: String) = System.out.println(result)


/**
 * [1a] return "true" if operator is one of:
 * - "+"
 * - "-"
 * - "*"
 * - "/"
 *
 * [1b] else return "false"
 */
fun checkArguments(operator: String): Boolean {
    //the "when" matcher is useful when many acceptable values are present
    return when (operator) {
        ADD -> true
        SUBTRACT -> true
        MULTIPLY -> true
        DIVIDE -> true
        else -> false
    }
}

/**
 * [2a] execute the appropriate mathematical function on the operands, and return that result as a String
 */
fun evaluateBinomial(operandOne: Double, operandTwo: Double, operator: String): String {
    return when (operator) {
        ADD -> (operandOne + operandTwo).toString()
        SUBTRACT -> (operandOne - operandTwo).toString()
        MULTIPLY -> (operandOne * operandTwo).toString()
        DIVIDE -> (operandOne / operandTwo).toString()

        else -> ERROR_MESSAGE
    }
}



