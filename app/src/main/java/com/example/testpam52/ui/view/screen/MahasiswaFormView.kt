package com.example.testpam52.ui.view.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MahasiwaFormView(
    onSubmitButtonClickned: (MutableList<String>)->Unit,
    onBackButtonClickned:() -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    var listData: MutableList<String> = mutableListOf(nim,nama,email)
}