package com.example.habbitsappcorse24.home.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habbitsappcorse24.home.presentation.home.components.HomeQuote
import com.example.habbitsappcorse24.R
import com.example.habbitsappcorse24.home.presentation.home.components.HomeDateSelector
import java.time.ZonedDateTime

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        CenterAlignedTopAppBar(title = {
            Text(text = "Home" )
        }, navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Settings , contentDescription = "settings" )
            }
        })
    }) {
        Column(modifier = Modifier
            .padding(it)
            .padding(20.dp)) {
           HomeQuote(quote = " we  first make  oue habbits,and tehn our habbits make us. " ,
               author = " Anonymous",
               imageId = R.drawable.onboarding1 )
            Row(modifier =  Modifier.fillMaxWidth()) {
                Text(text = "Habits".uppercase(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.tertiary)
                HomeDateSelector(selectedDate = ZonedDateTime.now(), mainDate = ZonedDateTime.now(), onDateClick = {})

            }
        }

    }
    
}