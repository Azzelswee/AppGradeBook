package com.nbscollege.ourchive.screens.courses.comscicourse

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nbscollege.ourchive.navigation.DashboardNav
import com.nbscollege.ourchive.ui.theme.RedOrange2
import com.nbscollege.ourchive.ui.theme.fontFamily

const val COURSE_NAME = "name"
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseCard(course: CourseCodes, navController: NavController){
//    val name by remember {
//        mutableStateOf(course.name)
//    }


    Card(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .height(100.dp)
            .fillMaxWidth(),
        onClick = {
            navController.currentBackStackEntry?.savedStateHandle?.set(COURSE_NAME, course.name)
            navController.navigate(DashboardNav.CourseScreen.name)
        },
        colors = CardDefaults.cardColors(
            containerColor = RedOrange2,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(50.dp,Alignment.CenterHorizontally)
            ) {
                Text(text = course.code.uppercase(), fontFamily = fontFamily, fontSize = 20.sp)
                Text(text = course.name.uppercase(), fontFamily = fontFamily, fontSize = 20.sp)
            }



    }
}