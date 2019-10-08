package com.freelapp.myapplication

sealed class Resource<T>(open val data: T? = null) {
    data class Success<T>(override val data: T) : Resource<T>(data)
    data class Failure<T>(override val data: T? = null,
                          val error: Throwable? = null) : Resource<T>(data)
}