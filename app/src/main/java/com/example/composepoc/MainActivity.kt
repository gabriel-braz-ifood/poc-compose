package com.example.composepoc

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composepoc.ui.ComposePOCTheme
import com.example.composepoc.ui.ContainerViewState
import com.example.composepoc.ui.ViewState

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Container(ContainerViewState())
        }
    }
}

@Composable
private fun Container(viewState: ContainerViewState) {
    ComposePOCTheme {
        Column(Modifier.clickable {
            viewState.screenState.value = ScreenState.LOADED
        }) {
            when (viewState.screenState.value) {
                ScreenState.LOADED ->  Loaded(ViewState {
                    titleText.value = "Clicado novamente 2"
                })
                ScreenState.LOADING -> Loading()
                ScreenState.ERROR -> Error()
            }
        }
    }
}

@Composable
private fun Loaded(state: ViewState) {
    val image = painterResource(id = R.drawable.success_drawable)

    val countState = remember { mutableStateOf(0) }

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

}

@Composable
private fun Error() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Text(text = "Erro ao carregar")
    }
}


@Composable
private fun Loading() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Text(text = "Carregando")
    }
}


@Preview
@Composable
private fun PreviewLayoutLoading() {
    Container(ContainerViewState())
}

@Preview
@Composable
private fun PreviewLayoutLoaded() {
    Container(ContainerViewState())
}

@Preview
@Composable
private fun PreviewLayoutError() {
    Container(ContainerViewState())
}

enum class ScreenState {
    LOADING,
    LOADED,
    ERROR
}