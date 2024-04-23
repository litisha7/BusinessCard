package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BusinessCardHeader()
            Spacer(modifier = Modifier.height(32.dp))
            ContactInfoRow(R.drawable.phone, R.string.phone_number)
            ContactInfoRow(R.drawable.email, R.string.email_text)
            ContactInfoRow(R.drawable.share, R.string.share_text)
        }
    }
}

@Composable
fun BusinessCardHeader() {
    val image = painterResource(id = R.drawable.android_logo)
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier.size(150.dp, 120.dp)
    )
    Text(
        text = stringResource(R.string.name_surname),
        color = Color.White
    )
    Text(
        text = stringResource(R.string.business),
        color = Color(0xFF3ddc84)
    )
}

@Composable
fun ContactInfoRow(iconId: Int, textId: Int) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        val icon = painterResource(id = iconId)
        Icon(
            painter = icon,
            contentDescription = null,
            tint = Color(0xFF3ddc84),
            modifier = Modifier.padding(start = 60.dp)
        )
        Text(
            text = stringResource(textId),
            modifier = Modifier.padding(start = 25.dp),
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}
