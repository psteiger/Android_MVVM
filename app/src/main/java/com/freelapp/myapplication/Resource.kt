package com.freelapp.myapplication

import android.util.Log

sealed class Resource<T>(open val data: T? = null) {
    data class Success<T>(override val data: T) : Resource<T>()
    data class Failure<T>(override val data: T? = null,
                          val error: Throwable? = null) : Resource<T>()

    fun onSuccess(onSuccess: (data: T) -> Unit): Resource<T> {
        if (this is Success) onSuccess(data)
        Log.d("MainActivity", "data success = $data")
        return this
    }

    fun onFailure(onFailure: (data: T?, error: Throwable?) -> Unit): Resource<T> {
        if (this is Failure) onFailure(data, error)
        Log.d("MainActivity", "data error = $data")
        return this
    }
}