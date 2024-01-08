package com.example.aplikasilaundry.ui.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.aplikasilaundry.data.Pesanan
import com.example.aplikasilaundry.repositori.PesananRepository

private const val HARGA_PER_KG = 3500

class FormViewModel(private val pesananRepository: PesananRepository) : ViewModel() {
    var uiStatePesanan by mutableStateOf(UIStatePesanan())
        private set

    private fun nullValidation(uiState: DetailLaundry = uiStatePesanan.detailLaundry): Boolean {
        return with(uiState) {
            nama.isNotBlank() && nohp.isNotBlank() && alamat.isNotBlank() && wangi.isNotBlank()
        }
    }

    fun updateUiState(detailLaundry: DetailLaundry) {
        uiStatePesanan =
            UIStatePesanan(
                detailLaundry = detailLaundry,
                isEntryValid = nullValidation(detailLaundry)
            )
    }
    suspend fun savePesanan() {
        if (nullValidation()) {
            pesananRepository.insertPesanan(uiStatePesanan.detailLaundry.toLaundry())
        }
    }
}

data class UIStatePesanan(
    val detailLaundry: DetailLaundry = DetailLaundry(),
    val isEntryValid: Boolean = false
)

data class DetailLaundry(
    val id: Int = 0,
    val nama: String = "",
    val nohp: String = "",
    val alamat: String = "",
    val harga: String = "",
    val wangi: String = ""
)

fun DetailLaundry.toLaundry(): Pesanan = Pesanan(
    id = id,
    nama = nama,
    nohp = nohp,
    alamat = alamat,
    harga = harga,
    wangi = wangi
)

fun Pesanan.toUiStatePesanan(isEntryValid: Boolean = false): UIStatePesanan = UIStatePesanan(
    detailLaundry = this.toDetailLaundry(),
    isEntryValid = isEntryValid
)

fun Pesanan.toDetailLaundry(): DetailLaundry = DetailLaundry(
    id = id,
    nama = nama,
    nohp = nohp,
    alamat = alamat,
    harga = harga,
    wangi = wangi
)