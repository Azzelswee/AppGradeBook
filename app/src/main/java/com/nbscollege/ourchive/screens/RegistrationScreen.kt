package com.nbscollege.ourchive.screens

import android.graphics.drawable.Icon
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
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


import com.nbscollege.ourchive.model.RegisterData

import com.nbscollege.ourchive.navigation.MainScreens
import com.nbscollege.ourchive.model.savedData
import com.nbscollege.ourchive.ui.theme.RedOrange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
    navController: NavController
){

    var username by remember{ mutableStateOf("") }
    var email by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    var confirmPass by remember{ mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var courses = listOf(
        "SELECT YOUR COURSE: ",
        "BS Computer Science",
        "BS Information Technology"
    )
    var disabledItem = "SELECT YOUR COURSE: "
    var selectedIndex by remember { mutableStateOf(0) }
    var seePassText by remember {
        mutableStateOf(false)
    }
//    savedData.add(RegisterData("Je19", "email", "123", ""))

    Column{
        Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ){
                TextButton(
                    onClick = {
                        navController.navigate(MainScreens.LOGIN.name)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = RedOrange
                    )) {
                    Icon(
                        imageVector = Icons.Rounded.KeyboardArrowLeft,
                        contentDescription = "Back Arrow",
                        modifier = Modifier
                            .size(35.dp))
                }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){


            Text(
                text = "REGISTER",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = RedOrange
            )
            TextField(
                value = username,
                onValueChange = { username = it },
                placeholder = { Text(text = "Username", color = Color.Gray)},
                trailingIcon = { Icon(Icons.Rounded.Person, "Username")},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier
                    .border(1.dp,Color.Black, RoundedCornerShape(5.dp)),
                textStyle = TextStyle(fontSize = 15.sp)
            )
            TextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text(text = "Email", color = Color.Gray)},
                trailingIcon = { Icon(Icons.Rounded.Email, "Email")},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier
                    .border(1.dp,Color.Black, RoundedCornerShape(5.dp))
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
                            Image( painterResource(id = R.drawable.eye), "Eye Open", modifier = Modifier.size(30.dp))

                        }
                        else{
                            Image( painterResource(id = R.drawable.eye_closed), "Eye Closed", modifier = Modifier.size(30.dp))
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
            TextField(
                value = confirmPass,
                onValueChange = { confirmPass = it },
                placeholder = { Text(text = "Confirm Password", color = Color.Gray)},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black
                ),
                modifier =

                if(password.isEmpty() && confirmPass.isEmpty()){

                    Modifier
                        .border(1.dp,Color.Black, RoundedCornerShape(5.dp))
                }else if (password == confirmPass){
                    Modifier
                        .border(1.dp,Color.Green, RoundedCornerShape(5.dp))
                } else {
                    Modifier
                        .border(1.dp,Color.Red, RoundedCornerShape(5.dp))
                },
                visualTransformation = PasswordVisualTransformation()

            )
            Box (
                modifier = Modifier
                    .height(50.dp)
                    .border(1.dp, Color.Black, RoundedCornerShape(5.dp))
                    .wrapContentSize(Alignment.CenterStart)
            ){
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(
                            onClick = { expanded = true }
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){

                    Text(
                        courses[selectedIndex],
                        modifier = Modifier
                            .fillMaxHeight()
                            .background(
                                Color.Transparent
                            )
                            .wrapContentSize(Alignment.CenterStart)
                            .padding(start = 20.dp)
                    )
                    if(!expanded){
                        Icon(Icons.Rounded.KeyboardArrowDown, contentDescription = "DropDown", modifier = Modifier.size(40.dp))
                    }else{
                        tween<Icon>(1000)
                        Icon(Icons.Rounded.KeyboardArrowUp, contentDescription = "DropUp", modifier = Modifier.size(40.dp))
                    }

                }


                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false },  modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                ) {
                    courses.forEachIndexed { index, s ->
                        DropdownMenuItem(
                            text = {
                                val disabledColor = if (s == disabledItem) {
                                    Color.Gray
                                } else {
                                    Color.Black
                                }
                                Text(text = s, color =  disabledColor)
                            },
                            onClick = {
                                selectedIndex = index
                                expanded = false

                            },
                            colors = MenuDefaults.itemColors(
                                textColor = Color.Black
                            )

                        )
                    }
                }

            }
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = {

                    navController.navigate(MainScreens.LOGIN.name)
                    val register = RegisterData(username, email, password, course = courses[selectedIndex])
                    savedData.add(register)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = RedOrange
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "REGISTER")
            }

        }

    }

}

fun getIndex(){

}


