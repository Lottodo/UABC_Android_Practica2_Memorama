package uabc.ico.memorama

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uabc.ico.memorama.ui.theme.MemoramaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MemoramaTheme {
                // A surface container using the 'background' color from the theme
                MainContent(
                    onClick = { doNothing() }
                )
            }
        }
    }

    fun doNothing(){}
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MemoramaTheme {
        Greeting("Android")
    }
}

@Composable
fun MainContent(
    onClick: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val rnds = (0..10).random()
        LazyVerticalGrid(columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.Center,
            content = {
                items(9) {i ->
                    Box(
                        modifier = Modifier.clickable { onClick }
                            .padding(8.dp)
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.Green),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Item #$i")
                    }
                }
            })
    }

}