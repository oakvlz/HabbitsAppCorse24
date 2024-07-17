package com.example.habbitsappcorse24.home.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.habbitsappcorse24.home.presentation.home.components.HomeQuote
import com.example.habbitsappcorse24.R

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
           HomeQuote(quote = " we  first make  oue habbits,and tehn our habbits make us. " , author = " Anonymous", imageId = R.drawable.onboarding1 )
        }

    }
    
}