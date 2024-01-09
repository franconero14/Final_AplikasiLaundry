package com.example.aplikasilaundry.ui.model

import androidx.lifecycle.SavedStateHandle
import com.example.aplikasilaundry.repositori.PesananRepository

class ResultViewModel(
    savedStateHandle: SavedStateHandle,
    private val pesananRepository: PesananRepository
)

data class ItemDetailUiState(
    val outOfStock: Boolean = true,
    val detailLaundry: DetailLaundry = DetailLaundry()
)