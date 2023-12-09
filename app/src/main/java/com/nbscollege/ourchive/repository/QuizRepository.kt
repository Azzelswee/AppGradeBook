package com.nbscollege.ourchive.repository

import com.nbscollege.ourchive.dao.QuestionDao
import com.nbscollege.ourchive.dao.UserDao
import com.nbscollege.ourchive.data.Question
import com.nbscollege.ourchive.data.User

class QuizRepository(private val userDao: UserDao, private val questionDao: QuestionDao) {

    // User-related functions
    suspend fun loginUser(username: String, password: String): User? {
        return userDao.loginUser(username, password)
    }

    suspend fun registerUser(user: User) {
        userDao.insertUser(user)
    }

    // Question-related functions
    suspend fun getAllQuestions(): List<Question> {
        return questionDao.getAllQuestions()
    }

    suspend fun getQuestionById(questionId: Long): Question? {
        return questionDao.getQuestionById(questionId)
    }

    suspend fun insertQuestion(question: Question) {
        questionDao.insertQuestion(question)
    }

    suspend fun updateQuestion(question: Question) {
        questionDao.updateQuestion(question)
    }

    suspend fun deleteQuestion(question: Question) {
        questionDao.deleteQuestion(question)
    }

    // Add other repository functions as needed
}

