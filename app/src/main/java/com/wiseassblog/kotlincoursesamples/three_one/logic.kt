package com.wiseassblog.kotlincoursesamples.three_one

//Control Logic

fun handleEvent(event: UserInterfaceEvent) {
    when (event) {
        is UserInterfaceEvent.Loading -> UserInterface.showLoadingScreen()
        is UserInterfaceEvent.Success -> UserInterface.showDashboardScreen()
        is UserInterfaceEvent.Error -> UserInterface.showErrorMessage()
    }
}


sealed class UserInterfaceEvent {
    object Loading : UserInterfaceEvent()
    object Success : UserInterfaceEvent()
    object Error : UserInterfaceEvent()
}

private object UserInterface {
    fun showLoadingScreen(){

    }

    fun showDashboardScreen(){

    }

    fun showErrorMessage(){

    }
}

//Computation Logic
fun sum(integerOne: Int, integerTwo: Int) = integerOne + integerTwo

private fun isOperator(char: Char): Boolean {
    return when {
        char.toString() == "+" -> true
        char.toString() == "-" -> true
        char.toString() == "*" -> true
        char.toString() == "/" -> true
        else -> false
    }
}
