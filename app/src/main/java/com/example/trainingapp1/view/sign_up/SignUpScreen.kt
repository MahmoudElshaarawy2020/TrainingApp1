package com.example.trainingapp1.view.sign_up

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.trainingapp1.R
import com.example.trainingapp1.network.data.remote.request.SignUpRequest
import com.example.trainingapp1.view.utils.SpannableText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(modifier : Modifier = Modifier,
                 navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isVisible by remember { mutableStateOf(false) }

    val viewModel: SignUpViewModel = hiltViewModel()
    val signUpResult by viewModel.signUpResult.collectAsState()
    val context = LocalContext.current

    Column(
        Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.mainBackground)),
        horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier.fillMaxWidth()) {

                IconButton(
                    modifier = modifier.padding(start = 27.dp, top = 50.dp),
                    onClick = {
                        navController.navigateUp()
                    }
                ) {
                    Icon(
                        modifier = modifier.size(width = 80.dp, height = 100.dp),
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "BackArrow"
                    )
                }
                Image(
                    modifier = modifier
                        .padding(start = 75.dp, top = 35.dp)
                        .size(width = 90.dp, height = 70.dp),
                    painter = painterResource(id = R.drawable.img_logo),
                    contentDescription = "AppLogo" )
            }
        Spacer(modifier = modifier.size(32.dp))

        Box(modifier = modifier
            .fillMaxSize()
            .padding(start = 27.dp, end = 27.dp)) {
            Column {
                Text(
                    text = stringResource(id = R.string.signUp),
                    modifier = modifier.fillMaxWidth(),
                    fontSize = 37.sp,
                    fontWeight = FontWeight.W600,
                    lineHeight = 45.sp,
                    color = colorResource(id = R.color.headerColorblack)
                )
                Text(
                    text = stringResource(id = R.string.grayText),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 7.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W300,
                    lineHeight = 20.sp,
                    color = Color.DarkGray
                )



                Text(
                    text = stringResource(id = R.string.PhoneNumber),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 5.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 20.sp,
                    color = Color.Black
                )

                OutlinedTextField(
                    value = name,
                    onValueChange = {name = it},
                    modifier = modifier
                        .size(width = 376.dp, height = 56.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.LightGray,
                        unfocusedBorderColor = Color.LightGray,
                        containerColor = Color.White
                    ),
                    singleLine = true,

                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone),

                    placeholder = { Text(
                        text = stringResource(id = R.string.PhoneNumber),
                        modifier = modifier
                            .fillMaxWidth()
                        ,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W300,
                        lineHeight = 20.sp,
                        color = colorResource(id = R.color.grayInfo)
                    )}
                )
                Text(
                    text = stringResource(id = R.string.Email),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 5.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 20.sp,
                    color = Color.Black
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = {email = it},
                    modifier = modifier
                        .size(width = 376.dp, height = 56.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.LightGray,
                        unfocusedBorderColor = Color.LightGray,
                        containerColor = Color.White
                    ),

                    singleLine = true,
                    placeholder = { Text(
                        text = stringResource(id = R.string.Email),
                        modifier = modifier
                            .fillMaxWidth()
                        ,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W300,
                        lineHeight = 20.sp,
                        color = colorResource(id = R.color.grayInfo)
                    )}
                )


                Text(
                    text = stringResource(id = R.string.City),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 5.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 20.sp,
                    color = Color.Black
                )

                OutlinedTextField(
                    value = city,
                    onValueChange = {city = it},
                    modifier = modifier
                        .size(width = 376.dp, height = 56.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.LightGray,
                        unfocusedBorderColor = Color.LightGray,
                        containerColor = Color.White
                    ),
                    singleLine = true,

                    placeholder = { Text(
                        text = stringResource(id = R.string.City),
                        modifier = modifier
                            .fillMaxWidth()
                        ,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W300,
                        lineHeight = 20.sp,
                        color = colorResource(id = R.color.grayInfo)
                    )}
                )

                Text(
                    text = stringResource(id = R.string.password),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 5.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 20.sp,
                    color = Color.Black
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = {password = it},
                    modifier = modifier
                        .size(width = 376.dp, height = 56.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.LightGray,
                        unfocusedBorderColor = Color.LightGray,
                        containerColor = Color.White
                    ),
                    placeholder = { Text(
                        text = stringResource(id = R.string.password),
                        modifier = modifier
                            .fillMaxWidth()
                        ,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W300,
                        lineHeight = 20.sp,
                        color = colorResource(id = R.color.grayInfo)
                    )},
                    singleLine = true,

                    visualTransformation =
                    if (isVisible) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },
                    trailingIcon = {
                        IconButton(onClick = { isVisible = !isVisible }) {
                            Icon(
                                painter = painterResource(id = R.drawable.img_eye),
                                contentDescription = null,

                            )
                        }
                    },
                )

                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 17.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically) {

                    var isChecked by remember { mutableStateOf(false) }

                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { isChecked = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = colorResource(id = R.color.blueButton),
                            uncheckedColor = colorResource(id = R.color.blueButton)
                        )
                    )

                    SpannableText()
                }

                Button(modifier = Modifier
                    .size(height = 70.dp, width = 356.dp)
                    .padding(top = 16.dp),
                    colors = ButtonDefaults
                        .buttonColors(containerColor = colorResource(id = R.color.blueButton)),
                    shape = RoundedCornerShape(30),
                    onClick = {
                        viewModel.signUp(
                            SignUpRequest(
                                name = name,
                                city = city,
                                email = email,
                                password = password
                            )
                        )
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.signUp),
                        modifier =Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        lineHeight = 19.sp
                    )

                }

                Row(modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center) {
                    Text(
                        modifier = modifier.padding(top = 15.dp),
                        text = stringResource(id = R.string.have_an_account),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 20.sp,
                        color = Color.Gray
                    )

                    Text(
                        modifier = modifier.padding(top = 15.dp)
                            .clickable {
                                navController.navigate("screen3")
                            },
                        text = " ${stringResource(id = R.string.Login)}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 20.sp,
                        color = colorResource(id = R.color.blueButton),
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
    }
}




