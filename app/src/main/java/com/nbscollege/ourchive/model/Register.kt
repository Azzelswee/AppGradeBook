package com.nbscollege.ourchive.model



import java.io.File


data class RegisterData(
    val username: String,
    val email: String,
    val password: String,
    val course: String
)

fun saveData(register: RegisterData){
    val header = "Username,Email,Password,Course"
    val data = "${register.username},${register.email},${register.password},${register.course}"

    val file = File("register.csv")

    val fieExists = file.exists()
    
}
