package com.example.aplikasilaundry.ui.model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasilaundry.repositori.PesananRepository
import com.example.aplikasilaundry.ui.pages.DataDestinasi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ResultViewModel(
    savedStateHandle: SavedStateHandle,
    private val pesananRepository: PesananRepository
) : ViewModel() {
    private val pesananId: Int = checkNotNull(savedStateHandle[DataDestinasi.laundryIdArg])
    val uiState: StateFlow<ItemDetailUiState> =
        pesananRepository.getPesananStream(pesananId).filterNotNull()
            .map { ItemDetailUiState(detailLaundry = it.toDetailLaundry()) }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ItemDetailUiState()
            )

    suspend fun deleteItem() {
        pesananRepository.deletePesanan(uiState.value.detailLaundry.toLaundry())
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class ItemDetailUiState(
    val outOfStock: Boolean = true,
    val detailLaundry: DetailLaundry = DetailLaundry()
)