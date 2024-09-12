package com.khana.stayfit.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.khana.stayfit.R
import com.khana.stayfit.ui.theme.AppFont
import com.khana.stayfit.ui.theme.color2A2C38
import com.khana.stayfit.ui.theme.color36343A
import com.khana.stayfit.ui.theme.color4023D7
import com.khana.stayfit.ui.theme.color983BCB
import com.khana.stayfit.ui.theme.colorACA3A5

@Composable
fun LoginAccount(navController: NavController) {
    val gradient = Brush.horizontalGradient(listOf(
        color983BCB, color4023D7
    ).reversed())

    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }

    Column(modifier  = Modifier
        .background(color2A2C38)
        .fillMaxSize()
        .padding(
            top = 10.dp
        ), verticalArrangement = Arrangement.SpaceBetween){

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().padding(
                horizontal = 20.dp
            )) {
            Text("Hey There,", color = Color.White,
                fontWeight = FontWeight.Medium,
                fontFamily = AppFont.fontFamily,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text("Welcome Back",
                fontSize = 22.sp,
                color = Color.White,
                fontFamily = AppFont.fontFamily,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldD(
                modifier = Modifier.fillMaxWidth(),
                state = email,
                placeholder = {
                    TextPlaceholder("email")
                },
                onValue = {
                    email.value = it
                },
                leading = R.drawable.ic_email
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldD(
                modifier = Modifier.fillMaxWidth(),
                state = password,
                placeholder = {
                    TextPlaceholder("password")
                },
                onValue = {
                    password.value = it
                },
                leading = R.drawable.ic_password,
                isPassword = true
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text("Forgot your password?", color =   colorACA3A5,
                fontFamily = AppFont.fontFamily,
                fontSize = 14.sp)
        }

        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom) {
            GradientButton(
                stringResource(R.string.login),
                gradient =gradient,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(20.dp)
            )

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically){
                Box(
                    Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .height(1.dp)
                        .background(
                            color36343A
                        )
                        .align(Alignment.CenterVertically))
                Text(
                    text = stringResource(R.string.or),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 10.dp))
                Box(
                    Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .height(1.dp)
                        .background(
                            color36343A
                        ))
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()) {
                Card(
                    colors = CardDefaults.cardColors().copy(
                        containerColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, color36343A)
                ) {
                    Image(painter = painterResource(R.drawable.ic_google), contentDescription = "",
                        Modifier
                            .width(60.dp)
                            .height(60.dp)
                            .padding(17.dp))
                }
                Spacer(modifier = Modifier.width(30.dp))
                Card(
                    colors = CardDefaults.cardColors().copy(
                        containerColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, color36343A)
                ) {
                    Image(painter = painterResource(R.drawable.ic_facebook), contentDescription = "",
                        Modifier
                            .width(60.dp)
                            .height(60.dp)
                            .padding(15.dp))
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row (horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp)){
                Text(text = stringResource(R.string.already_have_an_account), color = Color.White)
                Text(
                    stringResource(R.string.register), color = color983BCB,
                    fontFamily = AppFont.fontFamily,
                    fontWeight = FontWeight.Bold)
            }

        }
        Box(
            modifier = Modifier
                .navigationBarsPadding()
                .padding(15.dp)
        ) {

        }
    }

}
