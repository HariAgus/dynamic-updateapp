package com.haw.updateapllication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haw.updateapllication.ui.theme.UpdateAppFirebaseTheme
import com.haw.updateapllication.utils.RemoteConfig

class MainActivity : ComponentActivity() {

    private var isUpdateApp = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LaunchedEffect(key1 = Unit) {
                isUpdateApp = RemoteConfig.getUpdateApp()
            }

            UpdateAppFirebaseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (isUpdateApp) {
                        UpdateAppContent()
                    } else {
                        HomeContent()
                    }
                }
            }
        }
    }
}

@Composable
fun UpdateAppContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(280.dp),
            painter = painterResource(id = R.drawable.image_update_app),
            contentDescription = "ImageUpdate"
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "New Update is Available",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp
        )

        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = "The current version of this application is no longer supported." +
                    "We apologize for any inconvenience we may have caused you",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(80.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0XFF40A2E3)),
            shape = RoundedCornerShape(12.dp),
            onClick = { /*TODO : Navigate to play store for update */ }
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Update Now",
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = "No, Thanks! Close the app",
            color = Color(0xFF40A2E3),
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun HomeContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(120.dp),
            painter = painterResource(id = R.drawable.image_profile_circle),
            contentDescription = "ImageUpdate"
        )

        Spacer(modifier = Modifier.height(40.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0XFF40A2E3), shape = RoundedCornerShape(8.dp))
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = "Your Courses",
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.padding(top = 12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0XFF40A2E3), shape = RoundedCornerShape(8.dp))
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = "Payment",
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.padding(top = 12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0XFF40A2E3), shape = RoundedCornerShape(8.dp))
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = "Saved",
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        }

        Text(
            modifier = Modifier.padding(top = 12.dp),
            text = "Log out",
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UpdateAppFirebaseTheme {
        UpdateAppContent()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeContentPreview() {
    UpdateAppFirebaseTheme {
        HomeContent()
    }
}