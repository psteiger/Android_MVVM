package com.freelapp.myapplication.ViewModel

import androidx.lifecycle.LiveData

interface ResourceRepository<T> {
    val allItems : LiveData<Resource<T>>
}