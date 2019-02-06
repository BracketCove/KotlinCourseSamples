package com.wiseassblog.kotlincoursesamples.two_three

//Is the information always the same, every time the program is run? If so, store the information in a const val.

//Notes:
// 1. Constants are all caps by convention:
// 2. If the information is used in many different places in your program, consider using public (default)
// or internal visibility
internal const val ERROR_MESSAGE = "An error has occured."

// 3. If the information is only used in specific places, consider making it private or protected
private const val ADD = "+"

//This increases program efficiency, reduces typing errors, and improves program legibility if good names are chosen

//Is the information unchanging during run time, but may be different each time the program is run?
// If so, store the information in a val. In fact, always do your best to use val over vars!
val heightInCM: Double = 182.0
val userName: String = "Bob"


//When we pass arguments to a function, new references are created for each argument, that point to the same addresses
//in memory space. In Kotlin, the new references are always of type val
fun doSomething(argument: String){
    //Val may not be reassigned!
    //argument = ""
}

//Fundamentally speaking, a "val" is a read-only (immutable) reference type. This does not mean the data which val
//references, is itself immutable!
