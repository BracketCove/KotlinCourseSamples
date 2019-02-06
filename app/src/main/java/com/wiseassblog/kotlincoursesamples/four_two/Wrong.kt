package com.wiseassblog.kotlincoursesamples.four_two

fun main(args: Array<String>) {
    val mathOperator = args[0]

    var validArguments: Boolean
    var operandOne: Double = 0.0
    var operandTwo: Double = 0.0

    when (mathOperator) {
        "+" -> validArguments = true
        "-" -> validArguments = true
        "*" -> validArguments = true
        "/" -> validArguments = true
        else -> validArguments = false
    }

    if (args[1].toDoubleOrNull() == null) validArguments = false
    else operandOne = args[1].toDouble()


    if (args[2].toDoubleOrNull() == null) validArguments = false
    else operandTwo = args[2].toDouble()


    if (validArguments) {
        val result: String
        when (mathOperator) {
            "+" -> result = (operandOne + operandTwo).toString()
            "-" -> result = (operandOne - operandTwo).toString()
            "*" -> result = (operandOne * operandTwo).toString()
            "/" -> result = (operandOne / operandTwo).toString()

            else -> result = "An error has occured."
        }
        System.out.println(result)
    } else {
        System.out.println("An error has occured.")
    }
}


