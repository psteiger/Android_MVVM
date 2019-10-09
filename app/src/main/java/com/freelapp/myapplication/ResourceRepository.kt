package com.freelapp.myapplication

import androidx.lifecycle.LiveData
import com.google.firebase.database.GenericTypeIndicator

interface ResourceRepository<T> {
    val allUsers : LiveData<Resource<T>>
}

class ResourceRepositoryImpl<T>(path: String, type: GenericTypeIndicator<T>) : ResourceRepository<T> {
    override val allUsers = FirebaseResourceLiveData(path, type)
}