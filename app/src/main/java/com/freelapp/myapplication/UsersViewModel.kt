package com.freelapp.myapplication

import androidx.lifecycle.ViewModel

class UsersViewModel : ViewModel() {
    val usersLiveData = FirebaseResourceLiveData<HashMap<String, User>>("users")
}