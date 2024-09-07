package com.example.trainingapp1.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trainingapp1.R
import com.example.trainingapp1.model.Cities
import com.example.trainingapp1.model.citiesList

@Composable
fun PopularCitiesScreen(modifier: Modifier = Modifier,
                        cities: List<Cities>,
                        navController: NavController){
    val firstText = Font(R.font.montserrat_variablefont_wght)
    val firstFamily = FontFamily(firstText)

    Column(
        Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.mainBackground)),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier
                .fillMaxWidth()
                .padding(top = 35.dp),
            horizontalArrangement = Arrangement.Center) {
            Image(
                modifier = modifier
                    .size(width = 130.dp, height = 90.dp),
                painter = painterResource(id = R.drawable.img_logo),
                contentDescription = "AppLogo" )
        }
        Spacer(modifier = modifier.size(50.dp))
            LazyColumn(modifier = Modifier
                .fillMaxSize()
            ) {
                item {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp),
                        text = stringResource(id = R.string.Popular_Cities),
                        fontSize = 26.sp,
                        lineHeight = 31.sp,
                        fontWeight = FontWeight.W600,
                        color = colorResource(id = R.color.popularCitiesColor),
                    )
                }

                items(citiesList){ city->
                    CitiesComponents(cities = city, onClick = {
                        navController.navigate("screen5")
                    })
                }

            }

        }
    }




@Composable
fun CitiesComponents(modifier: Modifier = Modifier,
                     cities:Cities,
                     onClick : () -> Unit){
    Row(modifier
        .clickable { onClick()  }
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {

        Image(
            painter = painterResource(id = cities.image!!),
            contentDescription = "city1",
            modifier
                .size(width = 210.dp, height = 177.dp)
                .padding(start = 14.dp, end = 16.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(id = cities.name!!),
                fontSize = 17.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.W600,
                color = colorResource(id = R.color.popularCitiesColor))

            Text(
                text = stringResource(id = cities.review!!),
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight.W400,
                color = colorResource(id = R.color.reviewsColor))
        }

    }

}




