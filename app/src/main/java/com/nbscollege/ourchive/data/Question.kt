package com.nbscollege.ourchive.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question")
data class Question(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val questionText: String,
    val choices: List<String>,
    val correctAnswer: Int
)

val questionList = listOf(
    Question(
        questionText = "What is the time complexity of an algorithm that iterates through a list of n elements and performs a constant-time operation on each element?",
        choices = listOf(
            "O(1)", "O(n)", "O(log n)", "O(n^2)"),
        correctAnswer = 1)
)
