package com.nbscollege.ourchive.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nbscollege.ourchive.data.Question
import com.nbscollege.ourchive.ui.theme.RedOrange
import com.nbscollege.ourchive.ui.theme.fontFamily

@Composable
fun QuizCard(question: Question){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxHeight(0.3f)
                .border(1.dp, Color.Black),
            colors = CardDefaults.cardColors(
                containerColor = RedOrange,
                contentColor = Color.White
            )
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(question.questionText, fontFamily = fontFamily, fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            }
        }
        Column (
            modifier = Modifier
                .fillMaxSize()
                .border(1.dp, Color.Black)
        ){
            Button(onClick = {}) {

            }
        }
    }

}