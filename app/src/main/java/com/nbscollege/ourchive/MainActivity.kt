package com.nbscollege.ourchive

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nbscollege.ourchive.screens.access

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OurChiveApp()
            
            if(access){
                Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Incorrect Credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

