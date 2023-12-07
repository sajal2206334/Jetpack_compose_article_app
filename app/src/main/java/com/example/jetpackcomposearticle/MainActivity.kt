package com.example.jetpackcomposearticle

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposearticle.ui.theme.JetpackComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val image = painterResource(R.drawable.bg_compose_background__1_)
                    val title = stringResource(R.string.jetpack_compose_tutorial)
                    val shortDescription = stringResource(R.string.short_description)
                    val longDescription = stringResource(R.string.long_description)
                    ArticleCard(
                        imagePainter = image,
                        title = title,
                        shortDescription = shortDescription,
                        longDescription = longDescription
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleCard(
    imagePainter: Painter,
    title : String,
    shortDescription : String,
    longDescription : String,
    modifier: Modifier = Modifier,
) {
    Column {
        Image(painter = imagePainter, contentDescription = null)
        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = shortDescription,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = longDescription,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ArticleCardPreview() {
    val image = painterResource(R.drawable.bg_compose_background__1_)
    val title = stringResource(R.string.jetpack_compose_tutorial)
    val shortDescription = stringResource(R.string.short_description)
    val longDescription = stringResource(R.string.long_description)
    JetpackComposeArticleTheme {
        ArticleCard(imagePainter = image, title = title, shortDescription = shortDescription, longDescription = longDescription)
    }
}