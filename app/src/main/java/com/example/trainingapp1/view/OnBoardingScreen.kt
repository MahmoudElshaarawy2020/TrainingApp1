package com.example.trainingapp1.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.trainingapp1.R

@Composable
fun OnBoardingScreen(
    modifier:Modifier = Modifier,
    navController: NavController
) {
    val mainTitle = Font(R.font.hiatus1)
    val firstText = Font(R.font.montserrat_variablefont_wght)
    val myFontFamily = FontFamily(mainTitle)
    val firstFamily = FontFamily(firstText)
    Box(modifier = Modifier
        .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background1),
            contentScale = ContentScale.FillBounds,
            contentDescription = "Background image",
            modifier = Modifier
                .fillMaxSize()
                .matchParentSize()
        )
    }
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {

            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 390.dp),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.aspen),
                fontSize = 116.sp,
                fontFamily = myFontFamily,
                color = Color.White,
            )


            Text(modifier = Modifier
                .padding(start = 37.dp)
                .fillMaxWidth(),
                textAlign = TextAlign.Start,
                text = stringResource(id = R.string.onBoardingText1),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 27.sp, lineHeight = 30.sp,
                color = Color.White,
            )
            Text(modifier = Modifier.padding(start = 37.dp, end = 47.dp),
                text = stringResource(id = R.string.onBoardingText2),
                fontSize = 47.sp, lineHeight = 53.sp,
                style = MaterialTheme.typography.bodyLarge,

                color = Color.White,
            )

            Button(modifier = Modifier
                .size(height = 70.dp, width = 400.dp)
                .padding(start = 30.dp, top = 16.dp, end = 40.dp),
                colors = ButtonDefaults
                    .buttonColors(containerColor = colorResource(id = R.color.blueButton)),
                shape = RoundedCornerShape(16),
                onClick = {
                    navController.navigate("screen3")
                }
            ) {
                Text(
                    text = stringResource(id = R.string.ButtonText1),
                    modifier =Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    lineHeight = 19.sp
                )
                
            }
        }
}

