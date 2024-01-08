package com.example.aplikasilaundry.repositori

import com.example.aplikasilaundry.data.Pesanan
import kotlinx.coroutines.flow.Flow

interface PesananRepository {
    fun getAllPesananStream(): Flow<List<Pesanan>>

    fun getPesananStream(id: Int): Flow<Pesanan?>


}