package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.data.DataSource
import com.example.artspace.model.ArtSlide
import com.example.artspace.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(
        modifier: Modifier = Modifier
    )
{
    val dataSource: List<ArtSlide> = DataSource().loadSlides()
    val artSlides: List<ArtSlide> = remember { dataSource }
    var currentIndex by remember { mutableStateOf(0) }
    var artSlide: ArtSlide = artSlides[currentIndex]

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtImage(artSlide, modifier = modifier)
        Placard(artSlide, modifier = modifier)
        Spacer(modifier = Modifier.height(8.dp))
        Navigation(
            onPrevClick = {
                if (currentIndex > 0) {
                    currentIndex--
                } else {
                    currentIndex = artSlides.size - 1
                }

            }, onNextClick = {
                if (currentIndex < artSlides.size - 1) {
                    currentIndex++
                } else {
                    currentIndex = 0
                }
            }, modifier = modifier)
    }
}


@Composable
fun ArtImage(slide: ArtSlide, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(slide.imageResourceId),
        contentDescription = stringResource(slide.imageDescriptionId),
        contentScale= ContentScale.Companion.FillWidth,
        modifier = Modifier
            .wrapContentSize()
            .size(500.dp)
            .padding(2.dp)
    )
}
@Composable
fun Placard(slide: ArtSlide, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(100.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = slide.imageDescriptionId),
                fontStyle = FontStyle.Italic,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )
//            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = stringResource(id = slide.artistId),
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
        }
    }
}
@Composable
fun Navigation(
    onPrevClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier.fillMaxWidth()) {
        Button(
            onClick = onPrevClick,
            shape = RoundedCornerShape(25.dp),
            modifier = modifier
                .weight(1f)
                .padding(4.dp)
        ) {
            Text(
                text = "Previous",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Button(
            onClick = onNextClick,
            shape = RoundedCornerShape(25.dp),
            modifier = modifier
                .weight(1f)
                .padding(4.dp)
        ) {
            Text(
                text = "Next",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
//        ArtSpaceApp()
    }
}