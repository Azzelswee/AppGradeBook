package com.nbscollege.ourchive.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nbscollege.ourchive.data.User
import com.nbscollege.ourchive.database.QuizDatabase
import com.nbscollege.ourchive.navigation.MainScreens
import com.nbscollege.ourchive.repository.UserRepository
import com.nbscollege.ourchive.screens.courses.comscicourse.courses
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository: UserRepository


    init {
        val database = QuizDatabase.getInstance(application)
        userRepository = UserRepository(database.userDao())
    }

    private val _loggedInUser = MutableLiveData<User>()
    val loggedInUser: LiveData<User>
        get() = _loggedInUser

    fun loginUser(username: String, password: String) {
        viewModelScope.launch {
            // Perform database operation on the background thread
            val user = userRepository.loginUser(username, password)

            _loggedInUser.value = user

            println(_loggedInUser.value)

        }
    }
}