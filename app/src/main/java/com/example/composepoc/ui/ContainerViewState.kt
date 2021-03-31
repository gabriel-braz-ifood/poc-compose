package com.example.composepoc.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.composepoc.ScreenState

class ContainerViewState {
    val screenState = mutableStateOf(ScreenState.LOADING)
}