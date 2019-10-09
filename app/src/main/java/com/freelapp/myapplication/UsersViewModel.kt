package com.freelapp.myapplication

import androidx.lifecycle.ViewModel
import com.google.firebase.database.GenericTypeIndicator
import java.util.HashMap;

class UsersViewModel : ViewModel() {
    val usersLiveData =
        ResourceRepositoryImpl(
            "users",
            (HashMap<String, User>()).type
        ).allUsers

    inline val <reified T> T.type
        get() = object : GenericTypeIndicator<T>() {}
}