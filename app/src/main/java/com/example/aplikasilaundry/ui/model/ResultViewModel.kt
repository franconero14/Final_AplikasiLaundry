package com.example.aplikasilaundry.ui.model

data class ItemDetailUiState(
    val outOfStock: Boolean = true,
    val detailLaundry: DetailLaundry = DetailLaundry()
)