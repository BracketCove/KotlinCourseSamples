package com.wiseassblog.kotlincoursesamples.two_four

//Some information changes all of the time! In this case, var is required
var playerLocationX: Double = 0.0
var playerLocattionY: Double = 0.0

fun renderFrame(moveX: Double, moveY: Double){
    playerLocationX += moveX
    playerLocattionY += moveY

    //... redraw scene
}

//variables are especially dangerous when concurrency is introduced to a program. We will not be going in to great
//detail about concurrency as it is one of the most complicated topics in Software Development, Architecture, and
// Engineering

//Pretend we called addNumbers(1, 1)
fun addNumbers(first: Int, second: Int){
    val result = first + second
    //result would equal 2

    //pretend that another reference to our first argument exists elsewhere in the program, and it changes first to 2!
    println("$first + $second = $result!")

    //If this occurred, the console output would be "2 + 1 = 2!"
}

//There are many ways to avoid this issue, but most importantly, if you have to use a var, be very careful about which
//parts of your program have the potential to change it at a bad time.