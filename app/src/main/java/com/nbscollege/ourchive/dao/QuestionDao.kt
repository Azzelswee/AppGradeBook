package com.nbscollege.ourchive.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nbscollege.ourchive.data.Question

@Dao
interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: Question)

    @Query("SELECT * FROM question")
    suspend fun getAllQuestions(): List<Question>

    @Query("SELECT * FROM question WHERE id = :questionId")
    suspend fun getQuestionById(questionId: Long): Question?

    @Update
    suspend fun updateQuestion(question: Question)

    @Delete
    suspend fun deleteQuestion(question: Question)

    // Add other necessary queries for questions
}
