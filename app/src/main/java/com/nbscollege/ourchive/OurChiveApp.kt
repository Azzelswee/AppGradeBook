package com.nbscollege.ourchive

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.nbscollege.ourchive.navigation.DashboardNav
import com.nbscollege.ourchive.navigation.MainScreens
import com.nbscollege.ourchive.screens.ComSciScreen
import com.nbscollege.ourchive.screens.Dashboard
import com.nbscollege.ourchive.screens.ElectricityScreen
import com.nbscollege.ourchive.screens.ElectronicsScreen
import com.nbscollege.ourchive.screens.LoginScreen
import com.nbscollege.ourchive.screens.RegistrationScreen
import com.nbscollege.ourchive.screens.RoboticsScreen
import com.nbscollege.ourchive.viewmodel.ScreenViewModel

@Composable
fun OurChiveApp(){

    val viewModel: ScreenViewModel = viewModel()
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainScreens.AUTH.name
    ){
        navigation(startDestination = MainScreens.LOGIN.name, route = MainScreens.AUTH.name){
            composable(route = MainScreens.LOGIN.name){
                LoginScreen(navController)
            }
            composable(route = MainScreens.REGISTER.name){
                RegistrationScreen(navController)
            }
        }

        composable(route = MainScreens.DASHBOARD.name){
            Dashboard(navController = navController)
        }

    }
}