package com.route.e_commerce_compose.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ErrorDialog(
    title: String,
    message: String,
    showDialog: Boolean?,
    onRetry: () -> Unit,
    onDismiss: () -> Unit
) {
    if (showDialog == true) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize()
                .background(Color.Transparent)

        ) {
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.Center)
                    .padding(16.dp)
                    .clickable(enabled = false) {}
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = title, style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = message)
                    Row {
                        Button(
                            onClick = { onDismiss.invoke() },
                            colors = ButtonDefaults.buttonColors(Color.Black)
                        ) {
                            Text(text = "Cancel", color = Color.White)
                        }
                        Spacer(modifier = Modifier.width(25.dp))
                        Button(
                            onClick = { onRetry.invoke() },
                            colors = ButtonDefaults.buttonColors(Color.Black)
                        ) {
                            Text(text = "Retry", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}