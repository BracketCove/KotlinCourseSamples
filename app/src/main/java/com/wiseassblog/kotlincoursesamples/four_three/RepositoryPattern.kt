package com.wiseassblog.kotlincoursesamples.four_three

/*
Based on a primary separation of User Interface, Logic, and Data, let's
create the Things necessary for building a basic GUI Architecture Note Taking Application.
 */

/**
 * [1]
 * Contract Interface:
 * 1. Inputs user interface events
 * 2. Displays information to the user
 */
interface INoteContract {
    interface View {
        fun displayResult(result: String)
    }

    interface Logic {
        fun handleEvent(event: ViewEvent)
    }
}

//[2]
interface INoteRepository {
        fun getNote(): NoteResult
}

//[3]
sealed class ViewEvent {
    object OnStart : ViewEvent()
}

sealed class NoteResult {
    object Error : NoteResult()
    data class Success(val noteContents: String) : NoteResult()
}


/**
 * User Interface Class:
 * 1. Inputs user interface events
 * 2. Displays information to the user
 */
class NoteView(val logic: INoteContract.Logic) : INoteContract.View {

    override fun displayResult(result: String) = println(result)

    fun clickEvent() = logic.handleEvent(ViewEvent.OnStart)
}


/**
 * Logic Class:
 * 1. Handles input events
 * 2. Asks the repository for appropriate data
 */
class NoteLogic(): INoteContract.Logic {

    //Make sure to set these!
    lateinit var repository: INoteRepository
    lateinit var view: INoteContract.View

    override fun handleEvent(event: ViewEvent) {
        when (event) {
            is ViewEvent.OnStart -> getData()
        }
    }

    fun getData(){
        val result = repository.getNote()

        when (result) {
            is NoteResult.Success -> view.displayResult(result.noteContents)
            is NoteResult.Error -> view.displayResult(GENERIC_ERROR)
        }
    }

}

const val GENERIC_ERROR = "An error has occured."

/**
 * Data Class:
 * Returns either the appropriate data, or an error
 */
class NoteRepositoryImpl(val localDatabase: INoteRepository,
                         val remoteDatabase: INoteRepository): INoteRepository {
    override fun getNote(): NoteResult {
        val remoteResult = remoteDatabase.getNote()

        when (remoteResult) {
            is NoteResult.Success -> return remoteResult
            is NoteResult.Error -> return localDatabase.getNote()
        }
    }
}

object LocalNoteRepositoryImpl: INoteRepository {
    override fun getNote(): NoteResult = NoteResult.Success("Effort and Patience.")
}

object RemoteNoteRepositoryImpl: INoteRepository {
    override fun getNote(): NoteResult = NoteResult.Error
}

/**
 * Application Container:
 * 1. Create the different things in this program
 * 2. Bind the different things in this program together
 * 3. Set the program in motion
 *
 */
fun main(args: Array<String>) {
    val data = NoteRepositoryImpl(LocalNoteRepositoryImpl, RemoteNoteRepositoryImpl)
    val logic = NoteLogic()
    val view = NoteView(logic)
    logic.repository = data
    logic.view = view

    view.clickEvent()

}