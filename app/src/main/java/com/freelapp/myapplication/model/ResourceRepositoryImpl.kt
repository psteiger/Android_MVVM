package com.freelapp.myapplication.model

import com.freelapp.myapplication.viewmodel.ResourceRepository
import com.google.firebase.database.GenericTypeIndicator

class ResourceRepositoryImpl<T>(path: String,
                                type: GenericTypeIndicator<T>) : ResourceRepository<T> {

    override val allItems = FirebaseResourceLiveData(path, type)
}