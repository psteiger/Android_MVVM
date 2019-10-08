package com.freelapp.myapplication

import androidx.lifecycle.LiveData
import com.google.firebase.database.*

class FirebaseResourceLiveData<T>(path: String) : LiveData<Resource<T>>() {

    private val type = object : GenericTypeIndicator<T>() {}
    private val ref = FirebaseDatabase.getInstance().getReference(path)

    private val listener = object : ValueEventListener {
        override fun onDataChange(snap: DataSnapshot) {
            value = Resource.Success(snap.getValue(type)!!)
        }

        override fun onCancelled(error: DatabaseError) {
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