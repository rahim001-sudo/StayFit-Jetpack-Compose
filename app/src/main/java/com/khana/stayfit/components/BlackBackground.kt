package com.khana.stayfit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.khana.stayfit.R

@Preview
@Composable
fun BlackBackground(image:Int= R.drawable.ob_4){
  Surface(shape = RoundedCornerShape(8.dp),
      color = Color.Black,
      ) {
      Image(painter = painterResource(image), contentDescription = "",
          modifier = Modifier.size(35.dp).padding(8.dp))
  }
}