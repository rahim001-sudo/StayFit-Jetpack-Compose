package com.khana.stayfit.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.decode.ImageSource
import com.khana.stayfit.R
import com.khana.stayfit.components.BlackBackground
import com.khana.stayfit.ui.theme.color9D27B1

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(){
    Column(modifier = Modifier.fillMaxSize().padding(horizontal =15.dp)) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            Column() {
                Text("Welcome back")
                Spacer(Modifier.height(10.dp))
                Text("Masi Ramenqnade")
            }
            BlackBackground(R.drawable.ic_bell)
        }
        Spacer(modifier = Modifier.height(15.dp))
        Surface(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth().height(150.dp)
        ){
           Image(
               modifier = Modifier.fillMaxSize(),
               painter = painterResource(R.drawable.ic_home_banner),
               contentDescription = "",
               contentScale = ContentScale.FillBounds,
               colorFilter = ColorFilter.tint(color = color9D27B1, blendMode = BlendMode.DstAtop)
           )
            Column(modifier =Modifier.fillMaxSize()){
                Spacer(Modifier.height(8.dp))
                Text("BMI(Body Mass Index)")
                Spacer(Modifier.height(8.dp))
                Text("You have a normal wieght")
            }
        }
    }
}