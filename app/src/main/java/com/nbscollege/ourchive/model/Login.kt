package com.nbscollege.ourchive.model
import com.nbscollege.ourchive.savedData
import java.io.File
import java.io.FileReader
import java.io.FileWriter

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