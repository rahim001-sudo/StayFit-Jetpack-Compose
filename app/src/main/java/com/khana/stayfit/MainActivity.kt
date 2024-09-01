package com.khana.stayfit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khana.stayfit.ui.theme.StayFitTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StayFitTheme {
                Greeting()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Greeting() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Centered Text
        Column(modifier = Modifier.align(Alignment.Center)) {
            Row {
                Text(
                    text = "DIDPOOL FIT",
                    fontSize = 24.sp,

                )
                Text(
                    text = "DIDPOOL FIT",
                    fontSize = 24.sp,
                )
            }
            Text(
                text = "DIDPOOL FIT",
                fontSize = 24.sp,
            )
        }


        // Button at the Bottom
        Button(
            onClick = { /* Handle click */ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        ) {
            Text(text = "Click Me")
        }
    }
}

