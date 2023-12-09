package com.nbscollege.ourchive.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nbscollege.ourchive.dao.QuestionDao
import com.nbscollege.ourchive.dao.UserDao
import com.nbscollege.ourchive.data.Question
import com.nbscollege.ourchive.data.User
import com.nbscollege.ourchive.viewmodel.Converters

@Database(entities = [User::class, Question::class], version = 3, exportSchema = false)
@TypeConverters(Converters::class)
abstract class QuizDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun questionDao(): QuestionDao

    companion object {
        private const val DATABASE_NAME = "quiz_database"

        @Volatile
        private var INSTANCE: QuizDatabase? = null

        fun getInstance(context: Context): QuizDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context, QuizDatabase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}
