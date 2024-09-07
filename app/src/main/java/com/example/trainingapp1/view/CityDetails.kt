package com.example.trainingapp1.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.trainingapp1.R

@Composable
fun CityDetails(
    navController: NavController){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 40.dp, bottom = 15.dp)){
            Image(
                modifier = Modifier
                    .size(44.dp)
                    .clickable {
                        navController.navigateUp()
                    },
                painter = painterResource(id = R.drawable.arrow_img),
                contentDescription = null)

        }
            Image(
                painter = painterResource(id = R.drawable.city1_img),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 400.dp, height = 230.dp)
                    .padding(start = 27.dp, end = 27.dp),
                contentScale = ContentScale.FillBounds
                    )

            Spacer(modifier = Modifier.size(height = 10.dp, width = 100.dp))
            Row (modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically){

            Text(
        modifier = Modifier
            .padding(20.dp),
        text = stringResource(id = R.string.CityName),
        fontSize = 26.sp,
        lineHeight = 31.sp,
        fontWeight = FontWeight.W600,
        color = colorResource(id = R.color.popularCitiesColor),
    )

    Text(
        modifier = Modifier
            .padding(start = 60.dp),
        text = stringResource(id = R.string.Reviews),
        fontSize = 14.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.W400,
        color = colorResource(id = R.color.reviewsColor))
}

        Text(
            modifier = Modifier
                .padding(20.dp),
            text = stringResource(id = R.string.LongText),
            fontSize = 14.sp,
            lineHeight = 17.sp,
            fontWeight = FontWeight.W400,
            color = colorResource(id = R.color.longTextColor),
        )


    }
}

@Preview(showBackground = true)
@Composable
fun CityDetailsPreview(){
    CityDetails(
        navController = rememberNavController())
}