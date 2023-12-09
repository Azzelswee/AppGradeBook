package com.nbscollege.ourchive.repository

import com.nbscollege.ourchive.dao.UserDao
import com.nbscollege.ourchive.data.User

class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun loginUser(username: String, password: String): User?{

        return userDao.loginUser(username, password)
    }
}