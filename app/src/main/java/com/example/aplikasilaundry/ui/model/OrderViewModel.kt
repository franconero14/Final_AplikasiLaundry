package com.example.aplikasilaundry.ui.model

import androidx.lifecycle.ViewModel
import com.example.aplikasilaundry.repositori.PesananRepository

class OrderViewModel(private val pesananRepository: PesananRepository) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}