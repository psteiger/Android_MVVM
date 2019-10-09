package com.freelapp.myapplication

data class User(
    val name: String? = null,
    val email: String? = null,
    val hash: HashMap<String, String> = hashMapOf(Pair("A", "B"))
)