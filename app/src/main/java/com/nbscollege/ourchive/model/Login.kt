package com.nbscollege.ourchive.model

data class LoginData(
    val username : String,
    val password: String
)

fun accessLogin(logIn: LoginData): Boolean{

    for(i in savedData) {
        if (logIn.username == i.username && logIn.password == i.password) {
            return true
        }
    }
    return false
}