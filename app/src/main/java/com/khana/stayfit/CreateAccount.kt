package com.khana.stayfit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.khana.stayfit.ui.theme.AppFont
import com.khana.stayfit.ui.theme.color161818
import com.khana.stayfit.ui.theme.color494345
import com.khana.stayfit.ui.theme.color8E67F3
import com.khana.stayfit.ui.theme.colorACA3A5

@Preview(showBackground = true)
@Composable
fun CreateAccount() {
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
        Column {
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
                    phoneNumber.value = it
                },
                leading = R.drawable.ic_password,
                isPassword = true
            )

            Row {
                Checkbox(checked = true, onCheckedChange = {

                })
                Spacer(modifier = Modifier.width(9.dp))
                ClickableText(text = annotatedString, style = MaterialTheme.typography.bodyLarge, onClick = { offset ->
                    annotatedString.getStringAnnotations(tag = "policy", start = offset, end = offset).firstOrNull()?.let {

                    }

                    annotatedString.getStringAnnotations(tag = "terms", start = offset, end = offset).firstOrNull()?.let {

                    }
                })


            }

        }
}

@Composable
private fun TextPlaceholder(text:String) {
    Text(
        text = text, color = colorACA3A5,
        fontFamily = AppFont.fontFamily, fontWeight = FontWeight.Normal
    )
}

@Composable
fun TextFieldD(
    state: MutableState<String>,
    placeholder: @Composable (() -> Unit),
    onValue: ((str: String) -> Unit),
    leading: Int,
    isPassword:Boolean=false
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
        trailingIcon = {
            if(isPassword){
                val image = if (passwordVisible)
                    R.drawable.ic_visible
                else R.drawable.ic_hide

                // Please provide localized description for accessibility services
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
        textStyle = TextStyle(fontFamily = AppFont.fontFamily, fontWeight = FontWeight.SemiBold),
        modifier = Modifier.padding(10.dp),
        value = state.value,
        placeholder = {
            placeholder.invoke()
        },
        shape = RoundedCornerShape(14.dp),
        onValueChange = onValue
    )
}