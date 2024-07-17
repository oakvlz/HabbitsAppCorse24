package com.example.habbitsappcorse24.core.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign


@Composable
fun HabitTitle(
    title: String,
    modifier: Modifier = Modifier,
    ) {

    Text(text = title.uppercase(), modifier = modifier
    , style = MaterialTheme.typography.titleSmall.copy(
           fontWeight = FontWeight.Bold ,
            color = MaterialTheme.colorScheme.tertiary
    ),
    textAlign =  TextAlign.Center
        )

}