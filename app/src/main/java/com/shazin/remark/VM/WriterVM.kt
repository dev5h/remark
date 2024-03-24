package com.shazin.remark.VM

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class WriterVM:ViewModel() {
    val inputText = mutableStateOf("")
    val isPreviewOpen = mutableStateOf(false)
}