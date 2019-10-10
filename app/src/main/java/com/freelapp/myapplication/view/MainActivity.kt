package com.freelapp.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.freelapp.myapplication.R
import com.freelapp.myapplication.model.User
import com.freelapp.myapplication.viewmodel.UsersViewModel

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val usersViewModel = ViewModelProviders.of(this).get(UsersViewModel::class.java)

        usersViewModel.usersLiveData.observe(this, Observer { resource ->

            resource.onSuccess { users ->
                usersLoaded(users)
            }.onFailure { lastValidUsers, error ->
                usersLoadingFailed(lastValidUsers, error)
            }
        })
    }

    private fun usersLoadingFailed(lastValidUsers: HashMap<String, User>?, error: Throwable?) {
        Log.d(TAG, "Error: ${error?.toString()}," +
                        "lastValidUsers: ${lastValidUsers?.toString()}")
    }


    private fun usersLoaded(users: HashMap<String, User>){
        Log.d(TAG, users.toString())
    }

}
