package com.freelapp.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import com.google.firebase.database.*

class FirebaseResourceLiveData<T>(path: String, type: GenericTypeIndicator<T>) : LiveData<Resource<T>>() {

    private val ref = FirebaseDatabase.getInstance().getReference(path)

    private val listener = object : ValueEventListener {
        override fun onDataChange(snap: DataSnapshot) {
            Log.d("MainActivity", "FirebaseResourceLiveData = $snap")
            (snap.getValue(type))?.let {
                value = Resource.Success(it)
            }
        }

        override fun onCancelled(error: DatabaseError) {
            Log.d("MainActivity", "FirebaseResourceLiveData = ${error.message}")
            value = Resource.Failure(value?.data, error.toException())
        }
    }

    override fun onActive() {
        ref.addValueEventListener(listener)
    }

    override fun onInactive() {
        ref.removeEventListener(listener)
    }
}