package com.wiseassblog.kotlincoursesamples.three_five

/*
Functional style Binomial Expression Calculator:
Build a calculator than does not use any assignment statements or mutable state
 */
fun main(args: Array<String>) {
    solveExpression(args)
}

fun getErrorMessage() = "An error has occured."

/**
 * Takes in an array an attempts to solve it if the items can form a valid expression:
 * 1. Array must have a length of 3
 * 2. First and Second Strings must be valid doubles
 * 3. Third String must be a valid operator
 *
 * True: Solve expression and display result
 * False: Show error message
 */
fun solveExpression(args: Array<String>) {
    //Validation Logic:
    if (args.size != 3) {
        println(getErrorMessage())
        return //stop execution here
    }

    if (firstAndSecondNotValid(args[0], args[1])) {
        println(getErrorMessage())
        return //stop execution here
    }

    if (thirdIsNotValid(args[0])) {
        println(getErrorMessage())
        return //stop execution here
    }


    println(
        solve(
            args[0].toDouble(),
            args[1].toDouble(),
            getOperation(args[2])
        )
    )
}

fun getOperation(s: String): (Double, Double) -> String {
    return when (s) {
        "+" -> { first: Double, second: Double -> (first + second).toString() }
        "-" -> { first: Double, second: Double -> (first - second).toString() }
        "/" -> { first: Double, second: Double -> (first / second).toString() }
        "*" -> { first: Double, second: Double -> (first * second).toString() }
        else -> { first: Double, second: Double -> getErrorMessage() }
    }
}

fun solve(
    d1: Double,
    d2: Double,
    operation: (Double, Double) -> String
): String = operation.invoke(d1, d2)

fun thirdIsNotValid(s: String): Boolean {
    return when (s) {
        "+" -> false
        "-" -> false
        "/" -> false
        "*" -> false
        else -> true
    }
}

/**
 * Valid strings must be convertable to doubles
 */
fun firstAndSecondNotValid(s: String, s1: String): Boolean {
    if (s.toDoubleOrNull() == null) return true
    if (s1.toDoubleOrNull() == null) return true
    return false
}



