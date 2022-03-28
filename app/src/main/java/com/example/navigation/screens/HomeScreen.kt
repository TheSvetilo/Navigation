package com.example.navigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigation.navigation.Screen

data class Word(val word: String)

@Composable
fun HomeScreen(
    navController: NavController
) {

    val testList = listOf(
        Word("Hello"), Word("World"), Word("Anna"), Word("Vlad"),
        Word("Android"), Word("Watch"), Word("Screen"),
        Word("Hello"), Word("World"), Word("Anna"), Word("Vlad"),
        Word("Android"), Word("Watch"), Word("Screen")
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
    ) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(
                text = "Home Screen",
                fontSize = MaterialTheme.typography.body1.fontSize,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(24.dp)
                    .clickable {
                        navController.navigate(Screen.Detail.route)
                    }
            )
        }

        LazyColumn {
            testList.map {
                item {

                    Text(
                        text = it.word,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .padding(24.dp)
                            .clickable {
                                navController.navigate(Screen.Detail.route)
                            },
                        color = Color.Black
                    )
                }
            }
        }
    }
}

