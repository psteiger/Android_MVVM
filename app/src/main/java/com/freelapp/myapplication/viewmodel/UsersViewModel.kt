package com.freelapp.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.freelapp.myapplication.model.ResourceRepositoryImpl
import com.freelapp.myapplication.model.User
import com.google.firebase.database.GenericTypeIndicator
import java.util.HashMap;

class UsersViewModel : ViewModel() {
    val usersLiveData =
        ResourceRepositoryImpl(
            "users",
            (HashMap<String, User>()).type
        ).allItems

    inline val <reified T> T.type
        get() = object : GenericTypeIndicator<T>() {}
}