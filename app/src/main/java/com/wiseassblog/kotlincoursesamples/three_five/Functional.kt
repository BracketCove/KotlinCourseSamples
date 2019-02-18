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

    if (thirdIsNotValid(args[2])) {
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
 * NOTE: There was a slight error in this function in the video, please use this version below. Thanks to Wiktor K. for pointing that out!
 */
fun firstAndSecondNotValid(s: String, s1: String): Boolean {
   // The two vertical bars represent an "or" boolean statement. In English, it says "if (s cannot be converted to a double OR s1 cannot be converted to a double, return true)"
    if (s.toDoubleOrNull() == null || s1.toDoubleOrNull() == null) return true
    return false
}
