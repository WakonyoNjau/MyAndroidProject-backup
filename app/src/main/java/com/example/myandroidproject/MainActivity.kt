package com.example.myandroidproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myandroidproject.navigation.AppNavHost
import com.example.myandroidproject.ui.theme.MyAndroidProjectTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAndroidProjectTheme{

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        AppNavHost()





                    }
            }
        }
    }
            }






//@Preview(showBackground = true, device = "id:Nexus One", showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//    MyAndroidProjectTheme {
//        Greeting("Android")
//    }
//}
//
//@Preview(showBackground = true, device = "id:Nexus One", showSystemUi = true)
//@Composable
//fun GreetingPreviewDark() {
//    MyAndroidProjectTheme(darkTheme = true) {
//        Greeting("Android")
//    }
//}
