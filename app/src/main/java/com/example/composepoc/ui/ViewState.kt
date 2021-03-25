package com.example.composepoc.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class ViewState {
    val titleText = mutableStateOf("Sucesso")

    val onTextClick = { titleText.value = "Clicado novamente" }
}