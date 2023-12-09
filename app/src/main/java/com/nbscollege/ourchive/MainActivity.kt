package com.nbscollege.ourchive

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nbscollege.ourchive.dao.UserDao
import com.nbscollege.ourchive.database.QuizDatabase
import com.nbscollege.ourchive.screens.CourseScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val userDao: UserDao by lazy {
                QuizDatabase.getInstance(this).userDao()
            }
            OurChiveApp()



        }
    }
}

