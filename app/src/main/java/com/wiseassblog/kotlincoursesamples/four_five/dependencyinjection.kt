package com.wiseassblog.kotlincoursesamples.four_five

//Dependency Injection made simple:


//This would be a Container class like "Application" or "Activity" in Android
fun main(args:Array<String>){
    val provider = DependencyProvider()
    DecisionMaker(
        provider.provideRepository(),
        provider.provideView()
    ).start()
}

class DependencyProvider{
    fun provideRepository(): IRepository = Repository
    fun provideView(): View = View
}

//This would be a Presenter, Controller, ViewModel, or something similar
class DecisionMaker(
    val repository: IRepository,
    val userInterface: IView
) {
    fun start(){
        //Note: I ALWAYS return ResultWrappers (a.k.a Either Monad) from my Repositories for easy Error Handling
        userInterface.displayData(repository.getData())
    }
}

//Below are our Dependencies and their Interfaces
interface IRepository {
    fun getData(): String
}

interface IView {
    fun displayData(data: String)
}

object Repository: IRepository {
    override fun getData() = "REAL DATA"
}

object View: IView {
    override fun displayData(data: String) = println(data)
}

