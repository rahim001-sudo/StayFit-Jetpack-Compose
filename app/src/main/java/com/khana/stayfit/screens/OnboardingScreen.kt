package com.khana.stayfit.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.khana.stayfit.model.OnboardingPage
import com.khana.stayfit.ui.theme.color161818

@Composable
fun OnboardingScreen (page: OnboardingPage){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .wrapContentSize()
            .verticalScroll(scrollState)
            .background(color161818),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Image(painter = painterResource(id = page.image) , contentDescription = "Step Number"
        , modifier = Modifier.
        width(300.dp).height(300.dp))
    }
}