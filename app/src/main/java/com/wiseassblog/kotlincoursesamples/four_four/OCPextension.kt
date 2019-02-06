package com.wiseassblog.kotlincoursesamples.four_four

class NoteLisView {

}

class NoteDetaiView {

}

class LogiView {

}


fun Any.showMessage(message: String) = println(message)

fun main(args: Array<String>) {
    val list = NoteLisView()
    val detail = NoteDetaiView()
    val login = LogiView()

    list.showMessage("Open")
    detail.showMessage("For")
    login.showMessage("Extension")
}