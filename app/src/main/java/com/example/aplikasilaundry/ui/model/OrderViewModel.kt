package com.example.aplikasilaundry.ui.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasilaundry.data.Pesanan
import com.example.aplikasilaundry.repositori.PesananRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class OrderViewModel(private val pesananRepository: PesananRepository) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val homeUiState: StateFlow<OrderUiState> =
        pesananRepository.getAllPesananStream().filterNotNull().map {
            OrderUiState(listPenyewa = it.toList())
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = OrderUiState()
        )

    data class OrderUiState(
        val listPenyewa: List<Pesanan> = listOf()
    )
}