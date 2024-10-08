package com.example.trainingapp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.trainingapp1.model.citiesList
import com.example.trainingapp1.ui.theme.TrainingApp1Theme
import com.example.trainingapp1.view.CityDetails
import com.example.trainingapp1.view.LoginScreen
import com.example.trainingapp1.view.OnBoardingScreen
import com.example.trainingapp1.view.PopularCitiesScreen
import com.example.trainingapp1.view.SignUpScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrainingApp1Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "screen1"){
                    composable("screen1"){
                        OnBoardingScreen(navController = navController)
                    }

                    composable("screen2") {
                        SignUpScreen(navController = navController)
                    }

                    composable("screen3") {
                        LoginScreen(navController = navController)
                    }

                    composable(
                        "screen4",

                    ){
                        PopularCitiesScreen(cities = citiesList, navController = navController)
                    }

                    composable("screen5"){
                        CityDetails(navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TrainingApp1Theme {
        Greeting("Android")
    }
}