package com.shazin.remark.VM

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shazin.remark.generateUUID
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class)
class WriterVM:ViewModel() {
    val isPreviewOpen = mutableStateOf(false)
    private val _text = MutableStateFlow("")
    val text: StateFlow<String> = _text
    val uuid = mutableStateOf(generateUUID())

    init {
        viewModelScope.launch {
            _text.debounce(1000)
                .collect(::saveToDatabase)
        }
    }

    fun updateText(text: String) {
        _text.value = text
    }

    override fun onCleared() {
        super.onCleared()
        saveToDatabase(_text.value)
    }

    private fun saveToDatabase(text: String) {
        
    }
}