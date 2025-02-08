package com.example.lab

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab.ui.theme.LabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val primaryColor = Color(0xFFFFFFFF)
        setContent {
            LabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black)
                    ) {
                        Introduction(
                            name = "Вадим Кирпиков",
                            description = "Backend | FullStack developer",
                            phoneNumber = "+79122281337",
                            email = "vkirpikov@bk.com",
                            color = primaryColor,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun Introduction(
    name: String,
    description: String,
    phoneNumber: String,
    email: String,
    color: Color,
    modifier: Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Avatar(modifier = modifier)
        TextSection(text = name, fontSize = 25.sp, color = color)
        TextSection(text = "$description \uD83D\uDE28", fontSize = 15.sp, color = color)
        SimpleClickableText()
    }

    ContactSection(phoneNumber = phoneNumber, email = email, modifier = modifier, color = color)
}

@Composable
fun TextSection(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit,
    color: Color = Color.Unspecified
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        textAlign = TextAlign.Center,
        color = color,
    )
}

@Composable
fun ContactSection(phoneNumber: String, email: String, modifier: Modifier, color: Color) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextSection(text = "\uD83D\uDCF1 $phoneNumber", fontSize = 15.sp, color = color)
        TextSection(text = "\uD83D\uDCEE $email", fontSize = 15.sp, color = color)
    }
}

@Composable
fun Avatar(modifier: Modifier = Modifier) {
    val foreground = painterResource(id = R.drawable.billy)
    Box(
        modifier = modifier
            .padding(16.dp)
    ) {
        Image(
            painter = foreground,
            contentDescription = "Foreground",
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.Center)
                .clip(
                    RoundedCornerShape(16.dp)
                )
        )
    }
}

@Composable
fun SimpleClickableText() {
    val context = LocalContext.current
    Text(
        text = "\uD83D\uDC49 GITHUB \uD83D\uDC48",
        color = Color.Green,
        fontSize = 20.sp,
        modifier = Modifier.clickable {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/vadimkirpikov"))
            context.startActivity(intent)
        }
    )
}



