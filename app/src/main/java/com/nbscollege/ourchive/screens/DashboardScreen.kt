package com.nbscollege.ourchive.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nbscollege.ourchive.R
import com.nbscollege.ourchive.model.RegisterData
import com.nbscollege.ourchive.model.savedData
import com.nbscollege.ourchive.navigation.DashboardNav
import com.nbscollege.ourchive.screens.courses.comscicourse.COURSE_NAME
import com.nbscollege.ourchive.screens.icons.IconList
import com.nbscollege.ourchive.ui.theme.RedOrange

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(navController: NavController) {

    val dashNav = rememberNavController()

    val i = savedData[savedData.size - 1]

    val id = listOf(
        R.drawable.robot,
        R.drawable.comsci
    )

    val names = listOf(
        "Computer Science",
        "Robotics"
    )

    var selected by remember {
        mutableStateOf(false)
    }

    var item by remember {
        mutableIntStateOf(1)
    }

    var filled by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(90.dp)
                    )
                    Text(text = "Welcome back, ${i.username}", fontSize = 20.sp)
                }

            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector =
                        if(item == 1){
                            filled = true
                            Icons.Filled.Home
                        }
                        else{
                            Icons.Outlined.Home
                        }
                    ,
                    contentDescription = "Home Icon",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable(
                            onClick = {
                                dashNav.navigate(DashboardNav.Home.name)
                                item = 1
                            }
                        ),
                    tint = if(filled && item == 1){
                        RedOrange
                    }else{
                        Color.Black
                    }

                )
                Icon(
                    imageVector = if(item == 2){
                        filled = true
                        Icons.Filled.Person
                    }
                    else{
                        Icons.Outlined.Person
                    },
                    contentDescription = "Account Icon",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable(
                            onClick = {
                                dashNav.navigate(DashboardNav.Profile.name)
                                item = 2
                            }
                        ),
                    tint = if(filled && item == 2){
                        RedOrange
                    }else{
                        Color.Black
                    })
                Icon(imageVector = if(item == 3){
                    filled = true
                    Icons.Filled.Settings
                }
                else{
                    Icons.Outlined.Settings
                }, contentDescription = "Settings Icon", modifier = Modifier
                    .size(30.dp)
                    .clickable(
                        onClick = {
                            dashNav.navigate(DashboardNav.Settings.name)
                            item = 3
                        }
                    ),
                    tint = if(filled && item == 3){
                        RedOrange
                    }else{
                        Color.Black
                    })
            }
        }
    ) {

        NavHost(navController = dashNav, startDestination = DashboardNav.Home.name, modifier = Modifier.padding(it)){
            composable(route = DashboardNav.Home.name){
                DashHome(navController = dashNav)
            }
            composable(route = DashboardNav.Profile.name){
                ProfileScreen(navController = dashNav)
            }
            composable(route = DashboardNav.Settings.name){
                SettingsScreen(navController = dashNav)
            }
            composable(route = DashboardNav.ComSci.name){
                ComSciScreen(navController = dashNav)
            }
            composable(route = DashboardNav.Robotics.name){
                RoboticsScreen(navController = dashNav)
            }
            composable(route = DashboardNav.Electronics.name){
                ElectronicsScreen(navController = dashNav)
            }
            composable(route = DashboardNav.Electricity.name){
                ElectricityScreen(navController = dashNav)
            }
            composable(route = DashboardNav.CourseScreen.name){name ->
//                println(name.savedStateHandle.get<String>(COURSE_NAME))
//                val courseName = name.savedStateHandle.get<String>(COURSE_NAME)
//                println(courseName+"H")
//                courseName?.let{
//                    CourseScreen(navController = navController,courseName)
//                }
                println(name.savedStateHandle.contains("name"))
                CourseScreen(navController = navController, "")

            }
        }

    }

}





