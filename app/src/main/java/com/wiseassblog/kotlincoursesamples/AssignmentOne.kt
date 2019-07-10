package com.wiseassblog.kotlincoursesamples

/*
Task 1:
Create a data model, using the data class construct in Kotlin, for an application you would like to build in the future.

Requirements:
- Think of at least 3 properties which make sense for the data model
- All properties must be of type val

Hint: If you are not sure what applications you may wish to build in the future, just think of something you like to do, and some kind of application which could be of some benefit to that activity. In the solutions for this assignment, I have chosen to create data models for the first kind of application I ever built; a Workout Log.
 */

data class Exercise(val name:String,
                    val type: String,
                    val repetitions: Int,
                    val weight: Double)

/*
Task 2:

 */