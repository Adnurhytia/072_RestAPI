package com.example.apiconsume.ui.kontak.screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.consumeapi.repository.KontakRepository
import com.example.consumeapi.ui.home.viewmodel.InsertUiState

class InsertViewModel(private val kontakRepository: KontakRepository) : ViewModel(){
    var insertKontakState by mutableStateOf(InsertUiState())
        private set
    fun updateInsertKontakState(insertUiState: InsertUiState){
        insertKontakState = InsertUiState(insertUiEvent = insertUiEvent)
    }
}