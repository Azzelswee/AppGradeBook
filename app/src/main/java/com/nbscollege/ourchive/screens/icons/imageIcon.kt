package com.nbscollege.ourchive.screens.icons

import com.nbscollege.ourchive.R
import com.nbscollege.ourchive.navigation.DashboardNav

data class ImageIcon(
    val iconId: Int,
    val name: String,
    val route: String
)

val iconList = listOf(
    ImageIcon(R.drawable.comsci, "Computer Science", DashboardNav.ComSci.name),
    ImageIcon(R.drawable.robot, "Robotics",DashboardNav.Robotics.name),
    ImageIcon(R.drawable.electronics, "Electronics", DashboardNav.Electronics.name),
    ImageIcon(R.drawable.electricity, "Electricity", DashboardNav.Electricity.name)
)