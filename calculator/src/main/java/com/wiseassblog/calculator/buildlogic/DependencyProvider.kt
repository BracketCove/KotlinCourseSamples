package com.wiseassblog.calculator.buildlogic

import com.wiseassblog.calculator.CalculatorActivity
import com.wiseassblog.calculator.data.CalculatorImpl
import com.wiseassblog.calculator.data.ValidatorImpl
import com.wiseassblog.calculator.userinterface.CalculatorLogic
import com.wiseassblog.calculator.userinterface.ICalculatorUI
import com.wiseassblog.kotlincalculator.data.EvaluatorImpl
import kotlinx.coroutines.Dispatchers

object DependencyProvider {
    fun provideLogic(main: CalculatorActivity): ICalculatorUI.Logic {
        return CalculatorLogic(
            main,
            CalculatorImpl(
                ValidatorImpl,
                EvaluatorImpl
            ),
            Dispatchers.Main
        )
    }
}