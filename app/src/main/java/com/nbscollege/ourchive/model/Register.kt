package com.nbscollege.ourchive.model
import java.io.File
import java.io.FileWriter


data class RegisterData(
    val username: String,
    val email: String,
    val password: String,
    val course: String
)

//fun saveData(register: RegisterData){
//    val header = "Username,Email,Password,Course"
//    val data = "${register.username},${register.email},${register.password},${register.course}"
//
//    val file = File("register.csv")
//
//    val fileExists = file.exists()
//    val fileWriter = FileWriter(file, true)
//    if (fileExists){
//        fileWriter.appendLine(header)
//    }
//    fileWriter.appendLine(data)
//
//    fileWriter.close()
//}


