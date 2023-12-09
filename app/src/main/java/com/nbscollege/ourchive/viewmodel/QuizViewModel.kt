package com.nbscollege.ourchive.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nbscollege.ourchive.data.Question
import com.nbscollege.ourchive.data.User
import com.nbscollege.ourchive.database.QuizDatabase
import com.nbscollege.ourchive.repository.QuizRepository
import com.nbscollege.ourchive.screens.courses.comscicourse.courses
import com.nbscollege.ourchive.screens.programs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuizViewModel(application: Application) : AndroidViewModel(application) {
    private val quizRepository: QuizRepository

    init {
        val database = QuizDatabase.getInstance(application)
        quizRepository = QuizRepository(database.userDao(), database.questionDao())
    }

    private val _loggedInUser = MutableLiveData<User>()
    val loggedInUser: LiveData<User>
        get() = _loggedInUser

    private val _allQuestions = MutableLiveData<List<Question>>()
    val allQuestions: LiveData<List<Question>>
        get() = _allQuestions

    fun loginUser(username: String, password: String) {
        viewModelScope.launch {
            val user = quizRepository.loginUser(username, password)
            _loggedInUser.value = user
        }
    }

    fun registerUser(username: String, email: String, password: String, selectedIndex: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            // Perform database operation on the background thread
            val user = User(username = username, email = email, password = password, course = programs[selectedIndex])
            quizRepository.registerUser(user)
        }
    }

    fun getAllQuestions() {
        viewModelScope.launch {
            val questions = quizRepository.getAllQuestions()
            _allQuestions.value = questions
        }
    }

    fun getQuestionById(questionId: Long) {
        viewModelScope.launch {
            // Handle the retrieved question as needed
            val question = quizRepository.getQuestionById(questionId)
        }
    }

    // Add other ViewModel functions as needed
}

