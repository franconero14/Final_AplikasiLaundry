package com.example.aplikasilaundry.ui.model

import androidx.lifecycle.SavedStateHandle
import com.example.aplikasilaundry.repositori.PesananRepository

class UpdateViewModel(
    savedStateHandle: SavedStateHandle,
    private val pesananRepository: PesananRepository
)