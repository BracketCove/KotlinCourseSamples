package com.wiseassblog.kotlincoursesamples.four_six


//Starter
class DependencyProvider{
    fun provideLocalRepo(): IRepository = LocalRepositoryImpl
    fun provideRemoteRepo(): IRepository = RemoteRepositoryImpl
}

data class User(
    val id: String,
    val name: String,
    val avatarUrl: String
)

sealed class ResultWrapper {
    data class Success(val user: User) : ResultWrapper()
    data class Exception(val message: String) : ResultWrapper()
}

interface IRepository {
    fun getUser(id: String): ResultWrapper
}

object LocalRepositoryImpl : IRepository {
    override fun getUser(id: String): ResultWrapper = ResultWrapper.Success(
        User(
            "1234567890",
            "Marcus Aurelius",
            "https://en.wikipedia.org/wiki/Marcus_Aurelius"
        )
    )
}

object RemoteRepositoryImpl : IRepository {
    override fun getUser(id: String): ResultWrapper = ResultWrapper.Exception(
        "No Network Connection"
    )
}