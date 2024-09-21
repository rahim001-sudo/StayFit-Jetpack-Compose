package com.khana.stayfit.screens

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import coil.decode.ImageSource
import com.khana.stayfit.R
import com.khana.stayfit.components.BlackBackground
import com.khana.stayfit.ui.theme.color983BCB
import com.khana.stayfit.ui.theme.color9D27B1



@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    backgroundColor = 0x000000)
@Composable
fun HomeScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .padding(horizontal = 15.dp)) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Transparent)
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Column() {
                Text("Welcome back",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    ))
                Spacer(Modifier.height(10.dp))
                Text("Masi Ramenqnade", style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                ),
                    color = MaterialTheme.colorScheme.onSecondaryContainer )
            }
            BlackBackground(R.drawable.ic_bell)
        }
        Spacer(modifier = Modifier.height(15.dp))
        Surface(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ){
            Row(
                modifier = Modifier
                    .paint(
                        painterResource(id = R.drawable.ic_home_banner),
                        contentScale = ContentScale.FillBounds,
                        colorFilter = ColorFilter.tint(
                            color = color9D27B1,
                            blendMode = BlendMode.DstAtop
                        )
                    )
            ) {
                Column(modifier = Modifier
                    .background(color = Color.Transparent)
                    .padding(
                        horizontal = 13.dp,
                        vertical = 13.dp
                    )){
                    Spacer(Modifier.height(8.dp))
                    Text("BMI(Body Mass Index)",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = MaterialTheme.colorScheme.onSecondaryContainer)
                    Spacer(Modifier.height(8.dp))
                    Text("You have a normal wieght",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSecondaryContainer)
                    Spacer(Modifier.height(15.dp))
                    GradientButton(text = "View More", gradient = Brush.horizontalGradient(
                        listOf(
                            MaterialTheme.colorScheme.tertiary,
                            MaterialTheme.colorScheme.onTertiary
                        )
                    )
                        , modifier = Modifier.padding(horizontal = 25.dp, vertical = 10.dp))
                }
                Box(modifier = Modifier
                    .size(200.dp).align(Alignment.CenterVertically)
                    .background(color = Color.Black)
                    .clip(ArcShape()).
                drawWithContent {
                    translate(top=-20f){
                        drawArc(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    color9D27B1,
                                    color983BCB
                                )
                            ),
                            -10f,
                            -90f,
                            true,
                        )
                    }
//                    drawContent()
                }){
                    Canvas(modifier =Modifier) {
//                        drawCircle(
//                            color = Color.Black,
//                            radius = 120f,
//                            center = Offset(50f,20f)
//                        )

                    }
                }

            }

        }
    }
}

fun ArcShape(): Shape {
    return GenericShape { size, _ ->
        val path = Path()

        // Start at the bottom left
        path.moveTo(0f, size.height)

        // Draw a line to the top left
        path.lineTo(0f, size.height * 0.4f)

        // Draw an arc from top left to top right
        path.arcTo(
            rect = Rect(0f, 0f, size.width, size.height * 0.8f),
            startAngleDegrees = 180f, // Start from the left side
            sweepAngleDegrees = 180f, // Sweep to the right side
            forceMoveTo = false
        )

        // Draw a line from top right to bottom right
        path.lineTo(size.width, size.height)

        // Close the path at the bottom
        path.lineTo(0f, size.height)

        // Finalize the path
        path.close()
    }
}