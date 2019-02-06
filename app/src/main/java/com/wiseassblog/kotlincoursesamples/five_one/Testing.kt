package com.wiseassblog.kotlincoursesamples.five_one

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


//Challenge: Build a program which accepts a String, and a Char (as a predicate), and outputs the number of times which that Char occurs in the String
//Before writing a given function, you must first write and execute a Test function.
fun main(args: Array<String>) {

}

class StringChecker {

    fun checkString(string: String, predicate: Char): Int {
        var occurences = 0
        string.forEach {// char: Char ->
            if (it == predicate) occurences++
        }
        return occurences
    }
}

class TestCollection {
    // "Potato" 'Z'
    @Test
    fun `No Occurences`(){
        val testString = "Potato"
        val testChar = 'Z'

        val checker = StringChecker()

        val result = checker.checkString(testString, testChar)

        assertEquals(result, 0)
    }

    // "Blin" 'i'
    @Test fun `One Occurence`(){
        val testString = "Blin"
        val testChar = 'i'

        val checker = StringChecker()

        val result = checker.checkString(testString, testChar)

        assertEquals(result, 1)
    }

    // "Antidisestablishmentarianist" 'i'
    @Test fun `Many Occurences`(){
        val testString = "Antidisestablishmentarianist"
        val testChar = 'i'

        val checker = StringChecker()

        val result = checker.checkString(testString, testChar)

        assertEquals(result, 5)
    }
}

