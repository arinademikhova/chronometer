package com.example.chronometer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                ChronometerApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChronometerApp() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Stopwatch") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // счетчик
            Text(
                text = "00:00",
                fontSize = 64.sp,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Кнопка START
            Button(
                onClick = {  },
                modifier = Modifier
                    .width(140.dp)
                    .height(48.dp)
            ) {
                Text("START", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Кнопка PAUSE
            Button(
                onClick = {  },
                modifier = Modifier
                    .width(140.dp)
                    .height(48.dp)
            ) {
                Text("PAUSE", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Кнопка RESET
            Button(
                onClick = {  },
                modifier = Modifier
                    .width(140.dp)
                    .height(48.dp)
            ) {
                Text("RESET", fontSize = 18.sp)
            }
        }
        }
}