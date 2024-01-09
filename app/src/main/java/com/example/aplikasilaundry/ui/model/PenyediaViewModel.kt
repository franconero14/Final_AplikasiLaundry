package com.example.aplikasilaundry.ui.model

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.aplikasilaundry.AplikasiLaundry

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { OrderViewModel(aplikasiLaundry().dataContainer.pesananRepository) }
        initializer {
            FormViewModel(aplikasiLaundry().dataContainer.pesananRepository)
        }
    }
}

fun CreationExtras.aplikasiLaundry(): AplikasiLaundry =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiLaundry)