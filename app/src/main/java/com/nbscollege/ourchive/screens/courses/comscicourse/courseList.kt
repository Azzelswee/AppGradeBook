package com.nbscollege.ourchive.screens.courses.comscicourse

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun CourseList(navController: NavController){
    LazyColumn(){
        items(courses){
            CourseCard(it,navController = navController)
        }
    }
}