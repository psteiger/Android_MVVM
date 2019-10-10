package com.freelapp.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.freelapp.myapplication.model.Car
import com.freelapp.myapplication.model.ResourceRepositoryImpl
import com.google.firebase.database.GenericTypeIndicator
import java.util.HashMap;

// Generics Versatil!

class CarsViewModel : ViewModel() {
    val carsLiveData =
        ResourceRepositoryImpl(
            "cars",
            (HashMap<String, Car>()).type
        ).allItems

    inline val <reified T> T.type
        get() = object : GenericTypeIndicator<T>() {}
}