package com.example.apiconsume.ui.kontak.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.consumeapi.repository.KontakRepository
import com.example.consumeapi.ui.home.viewmodel.InsertUiEvent
import com.example.consumeapi.ui.home.viewmodel.InsertUiState
import com.example.consumeapi.ui.home.viewmodel.toKontak
import kotlinx.coroutines.launch

class InsertViewModel(private val kontakRepository: KontakRepository) : ViewModel(){
    var insertKontakState by mutableStateOf(InsertUiState())
        private set
    fun updateInsertKontakState(insertUiState: InsertUiState){
        insertKontakState = InsertUiState(insertUiEvent = insertUiEvent)
    }

    suspend fun insertKontak(){
        viewModelScope.launch {
            try {
                kontakRepository.insertKontak(insertKontakState.insertUiEvent.toKontak())
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}

data class InsertUiState(
    val insertUiEvent: InsertUiEvent = InsertUiEvent(),
)