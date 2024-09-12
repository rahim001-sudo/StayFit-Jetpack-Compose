package com.khana.stayfit.screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.khana.stayfit.R
import com.khana.stayfit.ui.theme.AppFont
import com.khana.stayfit.ui.theme.color2A2C38
import com.khana.stayfit.ui.theme.color424456
import com.khana.stayfit.ui.theme.color983BCB

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun CompleteProfile(navController: NavController?=null){
    val options = listOf("Male", "Female", "Other")
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().background(color2A2C38)) {
        Image(painter = painterResource(R.drawable.img_complete_profile), contentDescription = "",
            Modifier.height(340.dp))
        Text("Lets Complete Your Profile",
            fontWeight = FontWeight.Bold,
            fontFamily = AppFont.fontFamily,
            color = Color.White,
            fontSize = 22.sp
        )
        Spacer(Modifier.height(10.dp))
        Text("it will help us to know more about you",
            fontFamily = AppFont.fontFamily,
            fontWeight = FontWeight.Bold,
            color = color424456,
            fontSize = 13.sp)
        Spacer(modifier = Modifier.height(20.dp))
        val expanded= remember { mutableStateOf(false) }
        val genderState = remember { mutableStateOf("") }
        val dateState = remember { mutableStateOf("0") }
        val heightState = remember { mutableStateOf("") }
        Column(modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally,).padding(horizontal = 30.dp), horizontalAlignment = Alignment.CenterHorizontally){
            ExposedDropdownMenuBox(
                modifier = Modifier.fillMaxWidth().padding(0.dp),
                expanded = expanded.value, onExpandedChange = {
                    expanded.value = !expanded.value
                }) {
                TextFieldD(true,genderState,
                    leading = R.drawable.ic_profile, onValue = {
                    }, placeholder = @Composable(){
                        TextPlaceholder("email")
                    }, modifier = Modifier.menuAnchor().padding(0.dp).fillMaxWidth())
                ExposedDropdownMenu(
                    modifier = Modifier.padding(0.dp),
                    expanded = expanded.value,
                    onDismissRequest = {
                        expanded.value = false
                    }
                ) {
                    options.forEach { selectionOption ->
                        DropdownMenuItem(
                            modifier = Modifier.padding(0.dp),
                            text = {
                                Text(selectionOption)
                            },
                            onClick = {
                                genderState.value = selectionOption
                                expanded.value = false
                            }
                        )
                    }
                }
            }

            TextFieldD(
                modifier = Modifier.fillMaxWidth().padding(PaddingValues(vertical = 10.dp)),
                leading = R.drawable.ic_calendar,
                state =dateState,
                placeholder = @Composable(){
                    TextPlaceholder("Date of birth")
                },
                onValue = {

                }
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                TextFieldD(
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    leading = R.drawable.ic_height,
                    state =heightState,
                    placeholder = @Composable(){
                        TextPlaceholder("Hieght")
                    },
                    onValue = {

                    }
                )
                Spacer(modifier = Modifier.width(15.dp))
                GradientButton(
                    "Kg",
                    gradient = Brush.horizontalGradient(listOf(
                        color424456,
                        color983BCB
                    )),
                    modifier = Modifier.width(60.dp).height(60.dp),
                )
            }
            Spacer(Modifier.height(15.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                TextFieldD(
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    leading = R.drawable.ic_weight,
                    state =heightState,
                    placeholder = @Composable(){
                        TextPlaceholder("Wieght")
                    },
                    onValue = {

                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                GradientButton(
                    "CM",
                    gradient = Brush.horizontalGradient(listOf(
                        color424456,
                        color983BCB
                    )),
                    modifier = Modifier.width(60.dp).height(60.dp),
                )
            }
            Spacer(Modifier.height(20.dp))
            GradientButton(
                text = "Next",
                modifier = Modifier.fillMaxWidth().padding(PaddingValues(
                    vertical = 17.dp
                )),
                gradient = Brush.horizontalGradient(listOf(
                    color424456,
                    color983BCB
                ).reversed())
            )
        }

    }
}