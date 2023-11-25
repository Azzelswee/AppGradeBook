package com.nbscollege.ourchive.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nbscollege.ourchive.R
import com.nbscollege.ourchive.model.RegisterData
import com.nbscollege.ourchive.model.savedData
import com.nbscollege.ourchive.screens.icons.IconList

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(navController: NavController){

    val i = savedData[savedData.size-1]

    val id = listOf(
        R.drawable.robot,
        R.drawable.comsci
    )

    val names = listOf(
        "Computer Science",
        "Robotics"
    )
    Scaffold(
        topBar = {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo", modifier = Modifier.size(90.dp))
                    Text(text = "Welcome back, ${i.username}", fontSize = 20.sp)
                }
                Text(text = "Dashboard", fontWeight = FontWeight.ExtraBold, fontSize = 40.sp, modifier = Modifier.padding(horizontal = 30.dp))
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Spacer(modifier = Modifier.height(0.dp))
            Text(text = "What do you want to learn?", fontSize = 20.sp, fontWeight = FontWeight.W300)
            IconList(navController)

        }
    }

}





