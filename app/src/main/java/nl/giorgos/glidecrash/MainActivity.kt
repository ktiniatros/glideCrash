package nl.giorgos.glidecrash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.CrossFade
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import nl.giorgos.glidecrash.ui.theme.GlideCrashTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalGlideComposeApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val image = "https://www.vriendenloterij.nl/_/image/77985f81-52b1-4fed-be26-a9a0dff881d8:671874632bd0942e527bfa28ddca8c6003d61bad/width-628/Picl%20Vriendenloterij%20header.jpg?filter=rounded%285%29%3Bsharpen%28%29"
        val imageItems = List(811) {
            image
        }

        setContent {
            GlideCrashTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn(content = {
                        items(imageItems.size) {
                            GlideImage(
                                model = imageItems[it],
                                transition = CrossFade,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                loading = placeholder(painterResource(id = R.drawable.placeholder)),
                                modifier = Modifier
                                    .height(200.dp)
                                    .fillMaxSize()
                                    .background(Color.White)
                            )
                        }
                    })
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
    GlideCrashTheme {
        Greeting("Android")
    }
}