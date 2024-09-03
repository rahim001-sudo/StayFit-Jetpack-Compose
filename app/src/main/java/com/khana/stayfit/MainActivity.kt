package com.khana.stayfit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khana.stayfit.ui.theme.AppFont
import com.khana.stayfit.ui.theme.StayFitTheme
import com.khana.stayfit.ui.theme.color2a2c38
import com.khana.stayfit.ui.theme.color4023D7
import com.khana.stayfit.ui.theme.color602CD3
import com.khana.stayfit.ui.theme.color8E67F3
import com.khana.stayfit.ui.theme.color983BCB
import com.khana.stayfit.ui.theme.colorB6B4C1
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StayFitTheme {
              CreateAccount()
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
            .background(color2a2c38)
    ) {
        // Centered Text
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Text(
                    text = "DIDPOOL",
                    fontSize = 40.sp,
                    color = color8E67F3,
                    fontFamily = AppFont.fontFamily,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    fontFamily = AppFont.fontFamily,
                    text = " FIT",
                    fontSize = 40.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                fontFamily = AppFont.fontFamily,
                text = "Everybody can train",
                fontSize = 20.sp,
                color = colorB6B4C1
            )
        }



        Button(
            contentPadding = PaddingValues(),
            colors = ButtonDefaults.buttonColors().copy(containerColor = color602CD3),
            onClick = { /* Handle click */ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp)
        ) {
            Box(
                modifier = Modifier.background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            color4023D7,
                            color983BCB
                        )
                    )
                )
            ) {
                Text(
                    text = "Get Started",
                    Modifier
                        .padding(15.dp)
                        .fillMaxWidth(), fontWeight = FontWeight.Bold,
                    fontSize = TextUnit(15f, TextUnitType.Sp),
                    fontFamily = AppFont.fontFamily,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

