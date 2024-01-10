package com.example.aplikasilaundry.ui.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasilaundry.repositori.PesananRepository
import com.example.aplikasilaundry.ui.pages.UpdateDestinasi
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class UpdateViewModel(
    savedStateHandle: SavedStateHandle,
    private val pesananRepository: PesananRepository
) : ViewModel() {
    var pesananUiState by mutableStateOf(UIStatePesanan())
        private set

    private val itemId: Int = checkNotNull(savedStateHandle[UpdateDestinasi.itemIdArg])

    init {
        viewModelScope.launch {
            pesananUiState = pesananRepository.getPesananStream(itemId)
                .filterNotNull()
                .first()
                .toUiStatePesanan(true)
        }
    }

    suspend fun updatePenyewa() {
        if (validasiInput(pesananUiState.detailLaundry)) {
            pesananRepository.updatePesanan(pesananUiState.detailLaundry.toLaundry())
        } else {
            println("Data tidak valid")
        }
    }

    fun updateUiState(detailLaundry: DetailLaundry) {
        pesananUiState =
            UIStatePesanan(
                detailLaundry = detailLaundry,
                isEntryValid = validasiInput(detailLaundry)
            )
    }

    private fun validasiInput(uiState: DetailLaundry = pesananUiState.detailLaundry): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && wangi.isNotBlank()
        }
    }
}