package com.freelapp.myapplication.viewmodel

import androidx.lifecycle.LiveData

interface ResourceRepository<T> {
    val allItems : LiveData<Resource<T>>
}