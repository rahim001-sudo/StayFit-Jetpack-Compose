package com.khana.stayfit.screens

import android.text.style.ClickableSpan
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.khana.stayfit.R
import com.khana.stayfit.ui.theme.AppFont
import com.khana.stayfit.ui.theme.color161818
import com.khana.stayfit.ui.theme.color2A2C38
import com.khana.stayfit.ui.theme.color36343A
import com.khana.stayfit.ui.theme.color4023D7
import com.khana.stayfit.ui.theme.color494345
import com.khana.stayfit.ui.theme.color983BCB
import com.khana.stayfit.ui.theme.colorACA3A5

@Composable
fun CreateAccount(navController: NavController) {
    val gradient = Brush.horizontalGradient(listOf(
        color983BCB, color4023D7
    ).reversed())
    val userName = remember {
        mutableStateOf("")
    }
    val phoneNumber = remember {
        mutableStateOf("")
    }
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }

    val annotatedString = buildAnnotatedString {
        append("By joining, you agree to the ")

        pushStringAnnotation(tag = "policy", annotation = "https://google.com/policy")
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            append("privacy policy")
        }
        pop()

        append(" and ")

        pushStringAnnotation(tag = "terms", annotation = "https://google.com/terms")

        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            append("terms of use")
        }

        pop()
    }

    val cbState = remember { mutableStateOf(false) }

    Column(modifier  = Modifier
        .background(color2A2C38)
        .fillMaxSize()
        .padding(
            top = 10.dp
        ), verticalArrangement = Arrangement.SpaceBetween){

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            ) {
            Text("Hey There,", color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontFamily = AppFont.fontFamily,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text("Create an account",
                fontSize = 22.sp,
                color = Color.White,
                fontFamily = AppFont.fontFamily,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldD(
                state = userName,
                placeholder = {
                    TextPlaceholder("Username")
                },
                onValue = {
                    userName.value = it
                },
                leading = R.drawable.ic_profile
            )
            TextFieldD(
                state = email,
                placeholder = {
                    TextPlaceholder("email")
                },
                onValue = {
                    email.value = it
                },
                leading = R.drawable.ic_email
            )
            TextFieldD(
                state = phoneNumber,
                placeholder = {
                    TextPlaceholder("phone")
                },
                onValue = {
                    phoneNumber.value = it
                },
                leading = R.drawable.ic_phone
            )
            TextFieldD(
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
            Row (modifier = Modifier.padding(horizontal = 10.dp)){
                Checkbox(checked = cbState.value, onCheckedChange = {
                    cbState.value = it
                })
                Spacer(modifier = Modifier.width(9.dp))
                Text(annotatedString, onTextLayout ={

                })
            }

        }

        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom) {
            GradientButton(
                stringResource(R.string.register),
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
                    stringResource(R.string.login), color = color983BCB,
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

    @Preview(showBackground = true)
    @Composable
    fun GradientButton(
        text: String="Some More",
        gradient : Brush=Brush.horizontalGradient(
            listOf(color983BCB,
                color494345)
        ),
        modifier: Modifier = Modifier.padding(horizontal = 22.dp, vertical = 20.dp),
        onClick: () -> Unit = { },
    ) {
        Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(gradient)
                    .then(modifier)
                    .clickable {
                        onClick.invoke()
                    }
                    ,
                text = text, color = Color.White,
                fontFamily = AppFont.fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )

    }

@Composable
fun TextPlaceholder(text:String) {
    Text(
        text = text, color = colorACA3A5,
        fontFamily = AppFont.fontFamily, fontWeight = FontWeight.Normal
    )
}

@Composable
fun TextFieldD(
    readOnly:Boolean=false,
    state: MutableState<String>,
    placeholder: @Composable (() -> Unit),
    onValue: ((str: String) -> Unit),
    leading: Int,
    isPassword:Boolean=false,
    modifier: Modifier = Modifier
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    TextField(
        colors = TextFieldDefaults.colors().copy(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            unfocusedContainerColor = color161818,
            focusedContainerColor = color161818,
            disabledIndicatorColor = Color.Transparent,
            focusedTextColor = colorACA3A5,
            unfocusedTextColor = colorACA3A5
        ),
        singleLine = true,
        trailingIcon = {
            if(isPassword){
                val image = if (passwordVisible)
                    R.drawable.ic_visible
                else R.drawable.ic_hide

                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = {passwordVisible = !passwordVisible}){
                    Image(painter  = painterResource(id = image), description, colorFilter = ColorFilter.tint(
                        colorACA3A5), modifier = Modifier
                        .width(20.dp)
                        .height(20.dp))
                }
            }
        },

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        leadingIcon = {
            Image(
                colorFilter = ColorFilter.tint(color = color494345),
                painter = painterResource(id = leading), contentDescription = "",
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp),
            )
        },
        readOnly = readOnly,
        textStyle = TextStyle(fontFamily = AppFont.fontFamily, fontWeight = FontWeight.Normal),
        modifier = modifier,
        value = state.value,
        placeholder = {
            placeholder.invoke()
        },
        shape = RoundedCornerShape(14.dp),
        onValueChange = onValue
    )
}