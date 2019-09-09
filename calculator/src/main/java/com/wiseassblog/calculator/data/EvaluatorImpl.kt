package com.wiseassblog.kotlincalculator.data

import com.wiseassblog.calculator.data.IEvaluator
import com.wiseassblog.calculator.domain.ResultWrapper
import com.wiseassblog.kotlincalculator.data.datamodel.Operand
import com.wiseassblog.kotlincalculator.data.datamodel.Operator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * 1. Break the expression down in to sets of operators and operands
 * 2. Loop through operators and operands
 * 3a. If current operator is * or /, is last operator in list, or next operator is + or -, evaluate current
 * 3b. Else, evaluate next operator with second and third operands.
 * 4a. Remove the operator, firstOperand, and Second Operand, then add evaluated result as first[0] operand
 * 4b. Remove second and third operands, remove second operator, then add evaluated result as second[1] operand
 * 5. Repeat until only one operand exists
 * Created by R_KAY on 12/21/2017.
 */
object EvaluatorImpl : IEvaluator {
    override suspend fun evaluateExpression(exp: String): ResultWrapper<Exception, String> {
        val operators: MutableList<Operator> = getOperators(exp)
        val operands: MutableList<Operand> = getOperands(exp)


        while (operands.size > 1) {
            val firstOperand = operands[0]
            val secondOperand = operands[1]
            val firstOperator = operators[0]
            val secondOperator: Operator? = operators.getOrNull(1)


            if (evaluateCurrentPair(firstOperator, secondOperator)) {
                val result = Operand(evaluatePair(firstOperand, secondOperand, firstOperator))
                operators.remove(firstOperator)
                operands.remove(firstOperand)
                operands.remove(secondOperand)

                operands.add(0, result)
            } else {

                val thirdOperand = operands[2]
                val result = Operand(evaluatePair(secondOperand, thirdOperand, secondOperator!!))

                operators.remove(secondOperator)
                operands.remove(secondOperand)
                operands.remove(thirdOperand)

                operands.add(1, result)
            }
        }

        //Last exp in block is returned via Single Expression Syntax
        return ResultWrapper.build { operands[0].value }
    }

    //if op is * or / (evaluateFirst), or no more operatorDataModels to follow,
    // or next op is NOT (evaluateFirst)
    private fun evaluateCurrentPair(
        firstOperator: Operator,
        secondOperator: Operator?
    ): Boolean {
        return when {
            firstOperator.evaluateFirst -> true
            secondOperator == null -> true
            secondOperator.evaluateFirst -> true
            else -> false
        }
    }

    private fun getOperands(expression: String): MutableList<Operand> {
        val operands = expression.split("+", "-", "/", "*")
        val outPut: MutableList<Operand> = arrayListOf()

        //Kotlin's answer to enhanced for loop
        operands.indices.mapTo(outPut) {
            Operand(operands[it])
        }
        return outPut
    }

    private fun getOperators(expression: String): MutableList<Operator> {
        //this ugly stuff is called Regex; Regular ExpressionDataModel/
        //Basically saying split based on number or decimal numbers.
        val operators = expression.split("\\d+(?:\\.\\d+)?".toRegex())
            .filterNot { it == "" }
            .toMutableList()
        val outPut: MutableList<Operator> = arrayListOf()

        operators.indices.mapTo(outPut) {
            Operator(operators[it])
        }
        return outPut
    }

    private fun evaluatePair(firstOperand: Operand, secondOperand: Operand, operatorModel: Operator): String {
        when (operatorModel.operatorValue) {
            "+" -> return (firstOperand.value.toFloat() + secondOperand.value.toFloat()).toString()
            "-" -> return (firstOperand.value.toFloat() - secondOperand.value.toFloat()).toString()
            "/" -> return (firstOperand.value.toFloat() / secondOperand.value.toFloat()).toString()
            "*" -> return (firstOperand.value.toFloat() * secondOperand.value.toFloat()).toString()
        }
        throw  IllegalArgumentException("Illegal Operator.")
    }

}