package com.wiseassblog.kotlincoursesamples.two_five

import java.util.*

//A class, is a collection of information (data) and instructions (functions) which make sense to be grouped together, and given a name.

//1. Class declaration: type of object, name of object
class AppUser(
    //2. Class Properties: data which is relevant to a specific class
    val name: String,
    val joinDate: String,
    val proVersion: Boolean
) {
    //3. Class body: This is where functions and other reference variables go
    fun getFirstInitial(): Char {
        //since a String is a sequence of Chars, we can just grab the Char at the first index
        return name[0]
    }
}

//As a general rule, classes which store data should not also manipulate data. We will discuss this in detail later on.
//Here is an actual User class from a project of mine:
data class User(
    val uid: String,
    val name: String,
    //we can use default properties (like |= ""| or |= "satellite_beam") if appropriate
    val profilePicUrl: String = "satellite_beam"
)

//data class is not mandatory to use, but it often useful for the objects which only store data like above.

fun main(args: Array<String>) {
    //To create a class, type the class name, and give it appropriate arguments for its properties:
    val aUser = AppUser(
        "Ryan",
        "Now",
        false
    )

    //This is fine because we used default properties!
    val user = User("8675309", "Bob")

    //We can also supply the properties explicitly
    val otherUser = User("43", "Ryan", "selfie.jpg")

}


//I will not introduce Jargon terms unless I really think they are important, and this is happens to be one of them.
//You might wonder, how do I decided what information or instructions should go in a particular class? While this
//is totally up to you as the developer, always try to make your classes "Cohesive." For example:

//Cohesive
class DogOne(
    val age: Int,
    val weight: Double,
    val height: Double,
    val name: String,
    val owner: User
) {
    fun makeNoise(){
        println("BARK!")
    }
}

//Not very Cohesive
class DogTwo(
    val bankAccountNumber: Int,
    val letterGrade: String,
    val fluentInGerman: Boolean
) {

    fun measureGravity(){
        println("BARK!")
    }
}

//Cohesion is the degree to which the properties, functions, and reference variables in a class, belong in that class.