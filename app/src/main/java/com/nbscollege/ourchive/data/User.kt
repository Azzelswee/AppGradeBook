package com.nbscollege.ourchive.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nbscollege.ourchive.screens.courses.comscicourse.CourseCodes

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val username: String,
    val email: String,
    val password: String,
    val course: String
)
