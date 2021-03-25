package com.example.composepoc

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepoc.ui.ComposePOCTheme
import com.example.composepoc.ui.ViewState

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewStory(ViewState())
        }
    }
}

@Composable
private fun NewStory(state: ViewState) {
    val image = painterResource(id = R.drawable.success_drawable)

    val countState = remember { mutableStateOf(0) }

    ComposePOCTheme {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Image(painter = image, contentDescription = "", Modifier.clickable {
                state.onTextClick()
            })
            Text(text = state.titleText.value)
        }

//        Column(
//            modifier = Modifier
//                .padding(15.dp, 15.dp)
//                .border(3.dp, Color.Red, RoundedCornerShape(10.dp))
//                .background(Color.DarkGray)
//                .shadow(5.dp)
//                .padding(5.dp)
//                .fillMaxHeight()
//        ) {
//            Column(modifier = Modifier.weight(1f)) {
//                Image(
//                    image,
//                    "",
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clip(RoundedCornerShape(10.dp)),
//                    contentScale = ContentScale.Crop
//                )
//                Spacer(Modifier.height(4.dp))
//                Text("Cliques no botão: ${countState.value}")
//                Spacer(Modifier.height(20.dp))
//                Text(
//                    "A day wandering through the sandhills " +
//                            "in Shark Fin Cove, and a few of the " +
//                            "sights I saw",
//                    maxLines = 2,
//                    overflow = TextOverflow.Ellipsis,
//                    style = MaterialTheme.typography.h6
//                )
//                Text(
//                    "Davenport, California",
//                    color = Color.Yellow,
//                    style = MaterialTheme.typography.body1
//                )
//                Text(
//                    "December 2018",
//                    style = MaterialTheme.typography.body2
//                )
//                Text(stringResource(id = R.string.app_name))
//            }
//            Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
//                Counter(
//                    count = countState.value,
//                    updateCount = { newCount -> countState.value = newCount }
//                )
//                Spacer(Modifier.height(5.dp))
//                ResetCount { countState.value = 0 }
//            }
//        }
    }
}

//@Composable
//private fun Counter(count: Int, updateCount: (Int) -> Unit) {
//    Button(
//        onClick = { updateCount(count + 1) },
//    ) {
//        Text(text = "Botão clicado $count vezes", style = MaterialTheme.typography.button)
//    }
//}
//
//@Composable
//private fun ResetCount(resetCount: () -> Unit) {
//    Button(
//        onClick = { resetCount() },
//    ) {
//        Text(text = "Reset Count to 0", style = MaterialTheme.typography.button)
//    }
//}

@Preview
@Composable
private fun PreviewLayout() {
    NewStory(ViewState())
}
//
//@Preview
//@Composable
//private fun PreviewLayoutTest() {
//    Text(text = "Teste do Preview", color = Color.White)
//}
//
//@Preview
//@Composable
//private fun PreviewLayoutButton() {
//    Counter(count = 5, updateCount = { /*TODO*/ })
//}