package com.nbscollege.ourchive.model
import com.nbscollege.ourchive.savedData
import java.io.File
import java.io.FileReader
import java.io.FileWriter

data class LoginData(
    val username : String,
    val password: String
)

fun accessLogin(username: String, password: String): Boolean{

    for(i in savedData) {
        if (username == i.username && password == i.password) {
            return true
        }
    }
    return false
}