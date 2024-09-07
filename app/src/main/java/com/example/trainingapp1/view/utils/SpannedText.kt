package com.example.trainingapp1.view.utils

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.trainingapp1.R

@Composable
fun SpannableText() {
    val annotatedString = buildAnnotatedString {
        append(stringResource(id = R.string.spanText1))
        withStyle(style = SpanStyle(colorResource(id = R.color.blueButton))) {
            append(" ${stringResource(id = R.string.spanText2)}")
        }
    }

    Text(text = annotatedString)
}

@Preview(showBackground = true)
@Composable
fun SpannableTextPreview()  {
    SpannableText()
}