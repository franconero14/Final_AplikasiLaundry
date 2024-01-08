package com.example.aplikasilaundry.ui.model

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.aplikasilaundry.AplikasiLaundry

object PenyediaViewModel {
}

fun CreationExtras.aplikasiLaundry(): AplikasiLaundry =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiLaundry)