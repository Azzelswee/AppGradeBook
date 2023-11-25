package com.nbscollege.ourchive.screens


import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nbscollege.ourchive.R
import com.nbscollege.ourchive.model.LoginData
import com.nbscollege.ourchive.model.RegisterData
import com.nbscollege.ourchive.model.accessLogin
import com.nbscollege.ourchive.model.savedData

import com.nbscollege.ourchive.navigation.MainScreens
import com.nbscollege.ourchive.ui.theme.RedOrange
import com.nbscollege.ourchive.ui.theme.fontFamily

var access = false;

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController){
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var seePassText by remember {
        mutableStateOf(false)
    }

    var context: Context;
//    savedData.add(RegisterData("Je", "", "0", ""))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .border(1.dp, Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.8f)
                .padding(horizontal = 30.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,

            ){
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "OurChive Logo")
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = "WELCOME!", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.headlineLarge)
                Text(text = "Sign in to access your account", fontFamily = fontFamily)
            }
            TextField(
                value = username,
                onValueChange = { username = it },
                placeholder = { Text(text = "Username", color = Color.Gray)},
                trailingIcon = { Icon(Icons.Rounded.Person, "Username") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier
                    .border(1.dp, Color.Black, RoundedCornerShape(5.dp)),
                textStyle = TextStyle(fontSize = 15.sp)
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text(text = "Password", color = Color.Gray)},
                trailingIcon = {

                    TextButton(onClick = {
                        seePassText = !seePassText

                    }) {
                        if(seePassText){
                            Image( painterResource(id = R.drawable.eye), "Eye Open", modifier = Modifier.size(25.dp))

                        }
                        else{
                            Image( painterResource(id = R.drawable.eye_closed), "Eye Closed", modifier = Modifier.size(25.dp))
                        }
                    }

                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black
                ),
                visualTransformation = if(seePassText){ VisualTransformation.None } else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .border(1.dp,Color.Black, RoundedCornerShape(5.dp))
            )
            Spacer(modifier = Modifier.height(50.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp)
            ) {
                Button(
                    onClick = {
                        if(accessLogin(LoginData(username, password))){
                            access = true
                            navController.navigate(MainScreens.DASHBOARD.name)

                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = RedOrange
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "LOGIN")
                }
            }


            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(text = "Need account?")
                Text(
                    text = "Register Here",
                    modifier = Modifier.clickable(
                        onClick = {
                            navController.navigate(MainScreens.REGISTER.name)
                        }
                    ))
            }

        }
        
    }


}

