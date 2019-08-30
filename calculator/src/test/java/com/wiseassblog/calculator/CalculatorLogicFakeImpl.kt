package com.wiseassblog.androidrestcalculator

import com.wiseassblog.calculator.domain.ResultWrapper
import com.wiseassblog.calculator.userinterface.ICalculatorUI
import com.wiseassblog.calculator.userinterface.ViewEvent

class CalculatorLogicFakeImpl : ICalculatorUI.Logic {

    var viewEventCalled = false
    var handleResultCalled = false
    var result: ResultWrapper<Exception, String>? = null

    override fun handleViewEvent(event: ViewEvent) {
        viewEventCalled = true
    }

    override fun handleResult(result: ResultWrapper<Exception, String>) {
        this.result = result
        handleResultCalled = true
    }
}