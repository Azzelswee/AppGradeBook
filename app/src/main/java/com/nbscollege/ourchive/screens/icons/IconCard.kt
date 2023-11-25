package com.nbscollege.ourchive.screens.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nbscollege.ourchive.ui.theme.RedOrange

@Composable
fun IconCard(imageIcon: ImageIcon, navController: NavController){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = RedOrange
        ),
        modifier = Modifier
            .padding(10.dp)
            .clickable(
                onClick = {
                    navController.navigate(imageIcon.route)
                }
            ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(painter = painterResource(id = imageIcon.iconId), contentDescription = imageIcon.name, modifier = Modifier.size(100.dp))
            Text(text = imageIcon.name, color = Color.White)
        }

    }
}