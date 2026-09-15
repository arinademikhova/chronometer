package com.example.chronometer

import android.os.Bundle
import android.os.SystemClock
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.util.Locale

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
    // Состояние таймера
    var isRunning by remember { mutableStateOf(false) }
    var accumulatedTimeMillis by remember { mutableLongStateOf(0L) }
    var startTimeMillis by remember { mutableLongStateOf(0L) }
    var displayTimeMillis by remember { mutableLongStateOf(0L) }

    // Фоновый отсчет времени при isRunning = true
    LaunchedEffect(isRunning, startTimeMillis, accumulatedTimeMillis) {
        if (isRunning) {
            while (true) {
                val currentRealtime = SystemClock.elapsedRealtime()
                displayTimeMillis = accumulatedTimeMillis + (currentRealtime - startTimeMillis)
                delay(100)
            }
        }
    }

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

            val totalSeconds = displayTimeMillis / 1000
            val minutes = totalSeconds / 60
            val seconds = totalSeconds % 60
            val formattedTime = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)


            Text(
                text = formattedTime,
                fontSize = 64.sp,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Кнопка START
            Button(
                onClick = { },
                modifier = Modifier
                    .width(140.dp)
                    .height(48.dp)
            ) {
                Text("START", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Кнопка PAUSE
            Button(
                onClick = { },
                modifier = Modifier
                    .width(140.dp)
                    .height(48.dp)
            ) {
                Text("PAUSE", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Кнопка RESET
            Button(
                onClick = { },
                modifier = Modifier
                    .width(140.dp)
                    .height(48.dp)
            ) {
                Text("RESET", fontSize = 18.sp)
            }
        }
    }
}