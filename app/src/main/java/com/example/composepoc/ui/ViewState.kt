package com.example.composepoc.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.composepoc.ScreenState

class ViewState(val onClick: ViewState.() -> Unit) {
    val screenState = mutableStateOf(ScreenState.LOADING)

    val titleText = mutableStateOf("Sucesso")

    val onTextClick = { onClick(this) }
}