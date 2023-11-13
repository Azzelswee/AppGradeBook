package com.nbscollege.ourchive.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Indication
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nbscollege.ourchive.ui.theme.Gold
import com.nbscollege.ourchive.ui.theme.RedOrange
import kotlinx.coroutines.flow.merge

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(){

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

    Column{
        Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ){
                TextButton(
                    onClick = { /*TODO*/ },
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
                placeholder = { Text(text = "USERNAME", color = Color.Gray)},
                trailingIcon = { Icon(Icons.Rounded.Person, "Username")},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .border(1.dp,Color.Black, RoundedCornerShape(5.dp))
            )
            TextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text(text = "EMAIL", color = Color.Gray)},
                trailingIcon = { Icon(Icons.Rounded.Email, "Email")},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .border(1.dp,Color.Black, RoundedCornerShape(5.dp))
            )

            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text(text = "PASSWORD", color = Color.Gray)},
                trailingIcon = { Icon(Icons.Rounded.Lock, "Password")},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .border(1.dp,Color.Black, RoundedCornerShape(5.dp))
            )
            TextField(
                value = confirmPass,
                onValueChange = { confirmPass = it },
                placeholder = { Text(text = "CONFIRM PASSWORD", color = Color.Gray)},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .border(1.dp,Color.Black, RoundedCornerShape(5.dp))
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
                    Icon(Icons.Rounded.KeyboardArrowDown, contentDescription = "DropDown", modifier = Modifier.size(40.dp))
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
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = RedOrange
                ),
                modifier = Modifier

                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "REGISTER")
            }

        }

    }

}