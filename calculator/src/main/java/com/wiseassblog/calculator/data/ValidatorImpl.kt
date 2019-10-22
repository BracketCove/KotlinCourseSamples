package com.wiseassblog.calculator.data


/**
 * Created by R_KAY on 1/20/2018.
 */
object ValidatorImpl : IValidator {
    override suspend fun validateExpression(exp: String): Boolean {

        //check for valid starting/ending chars
        if (invalidStart(exp)) return false
        if (invalidEnd(exp)) return false
        if (invalidOperand(exp)) return false

        //Check for concurrent decimals and operators like "2++2"
        if (hasConcurrentOperators(exp)) return false
        if (hasConcurrentDecimals(exp)) return false
        if (hasTooManyDecimalsPerOperand(exp)) return false

        return true
    }


    private fun hasTooManyDecimalsPerOperand(expression: String): Boolean {
        val operands = expression.split("+", "-", "/", "*")
        operands.forEach { operand -> String
            val occurences = operand.count {
                    char -> Char
                char.equals('.')
            }

            if (occurences > 1) return true
        }

        return false
    }
    
    private fun invalidOperand(expression: String): Boolean {
        val operands = expression.split("+", "-", "/", "*")

        operands.forEach {operand -> String
            if (operand.endsWith(".")) return true
            if (operand.startsWith(".")) return true
        }

        return false
    }

    private fun invalidEnd(expression: String):Boolean {
         when {
            expression.endsWith("+") -> return true
            expression.endsWith("-") -> return true
            expression.endsWith("*") -> return true
            expression.endsWith("/") -> return true
            expression.endsWith(".") -> return true
            else -> return false
        }
    }

    private fun invalidStart(expression: String):Boolean {
        when {
            expression.startsWith("+") -> return true
            expression.startsWith("-") -> return true
            expression.startsWith("*") -> return true
            expression.startsWith("/") -> return true
            expression.startsWith(".") -> return true
            else -> return false
        }
    }

    private fun hasConcurrentDecimals(expression: String): Boolean {
        expression.indices
                .forEach {
                    if (it < expression.lastIndex) {
                        if (isConcurrentDecimal(expression[it], expression[it + 1])) {
                            return true
                        }
                    }
                }

        return false
    }

    private fun isConcurrentDecimal(current: Char, next: Char): Boolean {
        if (current.toString() == "." && next.toString() ==".") {
            return true
        }
        return false
    }

    private fun hasConcurrentOperators(expression: String): Boolean {
        expression.indices
                .forEach {
                    if (it < expression.lastIndex) {
                        if (isConcurrentOperator(expression[it], expression[it + 1])) {
                           return true
                        }
                    }
                }

        return false
    }

    private fun isConcurrentOperator(current: Char, next: Char): Boolean {
        if (isOperator(current) && isOperator(next)) {
            return true
        }
        return false
    }

    private fun isOperator(char: Char): Boolean {
        return when {
        //not sure why I had to toString() but char.equals("+") was not working as expected
            char.toString() == "+" -> true
            char.toString() == "-" -> true
            char.toString() == "*" -> true
            char.toString() == "/" -> true
            else -> false
        }
    }
}
