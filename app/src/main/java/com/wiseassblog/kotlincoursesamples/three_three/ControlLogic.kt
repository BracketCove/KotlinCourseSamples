package com.wiseassblog.kotlincoursesamples.three_three

//Control Structures drive the flow of a program:
fun retrieveData(networkConnected: Boolean): String {
    //Booleans may either be true or false
    if (networkConnected == true) {
        return CloudStorage.getRemoteData()
    } else {
        return DeviceStorage.getLocalData()
    }
}

object DeviceStorage {
    fun getLocalData() = ""
}

object CloudStorage {
    fun getRemoteData() = ""
}
