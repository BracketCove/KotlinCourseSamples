package com.wiseassblog.kotlincoursesamples.three_two

/**
 * This function accepts a String, and returns:
 * - an Int if the String is a valid integer: e.g. "1"
 * - null if the String is not a valid integer: e.g. "Potato"
 *
 * The question mark after the return type ("Int?") tells the program
 * that it may be an Int, or it may be a null
 */
fun safeConvertStringToInt(s: String): Int? {
   return when (s){
        "0" -> 0
        "1" -> 1
        "2" -> 2
        "3" -> 3
        "4" -> 4
        "5" -> 5
        "6" -> 6
        "7" -> 7
        "8" -> 8
        "9" -> 9
        else -> null
    }
}

fun main(args: Array<String>){
    if (args[0].length == 1) {
        val string = args[0] //get the first String

        println(safeConvertStringToInt(string))

        //Don't reinvent the wheel!
        println(string.toIntOrNull())
    }
}