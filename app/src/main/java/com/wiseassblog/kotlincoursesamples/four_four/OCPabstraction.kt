package com.wiseassblog.kotlincoursesamples.four_four

/*
Assume we are building an application which has many different features/screens
which the user can visit.

Problem:
In each class, I would like to implement the same function to output a message to the user. Since this function
will be available in all of the different UI classes, I would prefer to only have to write it one place; otherwise
I'm going to be writing the same function in every place I need it. Not only is this a waste of text, but if I
need to change this function for some reason, I would have to go change it in every class.

We have saying for that in Programing: Don't Repeat Yourself
 */

class NoteListView: View() {

}

class NoteDetailView: View() {

}

class LoginView: View() {

}

abstract class View {
    fun showMessage(message: String) = println(message)
}


fun main(args: Array<String>){
    val list = NoteListView()
    val detail = NoteDetailView()
    val login = LoginView()

    list.showMessage("Open")
    detail.showMessage("For")
    login.showMessage("Extension")
}