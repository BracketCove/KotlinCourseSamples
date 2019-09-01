package com.wiseassblog.calculator

import com.wiseassblog.calculator.data.ValidatorImpl
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidatorImplTest {

    val validator = ValidatorImpl

    val VALID_EXPRESSION_ONE: String = "2+2"
    val VALID_EXPRESSION_TWO: String = "6*8/6"
    val VALID_EXPRESSION_THREE: String = "6+8/2-7"

    val INVALID_EXPRESSION_ONE: String = "2+"
    val INVALID_EXPRESSION_TWO: String = "2++"
    val INVALID_EXPRESSION_THREE: String = "+1"
    val INVALID_EXPRESSION_FOUR: String = "2.."
    val INVALID_EXPRESSION_FIVE: String = "0.0.0 + 1"

    @Test
    fun `Test Valid Expression`() = runBlocking {
        val resultOne = validator.validateExpression(VALID_EXPRESSION_ONE)

        assertTrue(resultOne)

        val resultTwo = validator.validateExpression(VALID_EXPRESSION_TWO)

        assertTrue(resultTwo)

        val resultThree = validator.validateExpression(VALID_EXPRESSION_THREE)

        assertTrue(resultThree)
    }


    @Test
    fun `Test Invalid Expression`() = runBlocking {
        val resultOne = validator.validateExpression(INVALID_EXPRESSION_ONE)

        assertFalse(resultOne)

        val resultTwo = validator.validateExpression(INVALID_EXPRESSION_TWO)

        assertFalse(resultTwo)

        val resultThree = validator.validateExpression(INVALID_EXPRESSION_THREE)

        assertFalse(resultThree)

        val resultFour = validator.validateExpression(INVALID_EXPRESSION_FOUR)

        assertFalse(resultFour)

        val resultFive = validator.validateExpression(INVALID_EXPRESSION_FIVE)

        assertFalse(resultFive)

    }



}