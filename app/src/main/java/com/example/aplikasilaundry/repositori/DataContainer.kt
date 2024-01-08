package com.example.aplikasilaundry.repositori

import android.content.Context
import com.example.aplikasilaundry.data.LaundryDb

interface DataContainer {
    val pesananRepository: PesananRepository
}

class ContainerData(private val context: Context) : DataContainer {
    override val pesananRepository: PesananRepository by lazy {
        OffLineRepository(LaundryDb.getDatabase(context).pesananDao())
    }
}