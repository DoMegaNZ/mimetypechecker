package com.example.mimetypetest

import android.os.Bundle
import android.webkit.MimeTypeMap
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mimetypetest.ui.theme.MimetypeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MimetypeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

private val mimeTypeMap = MimeTypeMap.getSingleton()

@Composable
fun Greeting(name: String) {
    var extension by remember {mutableStateOf("") }
    val type by remember { derivedStateOf { mimeTypeMap.getMimeTypeFromExtension(extension) ?: "NO MIMETYPE FOUND"} }
    Column {
        TextField(value = extension,
            onValueChange = { extension = it })
        Text(text = type)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MimetypeTestTheme {
        Greeting("Android")
    }
}