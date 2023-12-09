package com.nbscollege.ourchive.viewmodel

// RegisterViewModel.kt
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.nbscollege.ourchive.data.User
import com.nbscollege.ourchive.database.QuizDatabase
import com.nbscollege.ourchive.repository.UserRepository
import com.nbscollege.ourchive.screens.courses.comscicourse.courses
import com.nbscollege.ourchive.screens.programs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository: UserRepository


    init {
        val database = QuizDatabase.getInstance(application)
        userRepository = UserRepository(database.userDao())
    }


    fun registerUser(username: String, email: String, password: String, selectedIndex: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            // Perform database operation on the background thread
            val user = User(username = username, email = email, password = password, course = programs[selectedIndex])
            userRepository.registerUser(user)
        }
    }
}
