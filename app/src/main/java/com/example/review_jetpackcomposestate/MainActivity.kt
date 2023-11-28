package com.example.review_jetpackcomposestate

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

// Importados à mão get e set.
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.review_jetpackcomposestate.ui.theme.ReviewJetpackComposeStateTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReviewJetpackComposeStateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // by remember: Lembra dos valores que a variável tinha, na tela anterior.
                    var vlrDoTextField by remember {
                        mutableStateOf("")
                    }
                    Column (modifier = Modifier.background(Color.LightGray)){
                        Text(text = "Insira seu texto:")
                        TextField(value = vlrDoTextField, onValueChange = {
                            vlrDoTextField = it;
                            Log.i("###", vlrDoTextField)
                        })
                        Text(text = "$vlrDoTextField")
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
    ReviewJetpackComposeStateTheme {
        Greeting("Android")
    }
}