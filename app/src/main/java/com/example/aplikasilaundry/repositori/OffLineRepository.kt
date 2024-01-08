package com.example.aplikasilaundry.repositori

import com.example.aplikasilaundry.data.Pesanan
import com.example.aplikasilaundry.data.PesananDao
import kotlinx.coroutines.flow.Flow

class OffLineRepository(private val pesananDao: PesananDao) : PesananRepository {
    override fun getAllPesananStream(): Flow<List<Pesanan>> {
        TODO("Not yet implemented")
    }

    override fun getPesananStream(id: Int): Flow<Pesanan?> {
        TODO("Not yet implemented")
    }

    override suspend fun insertPesanan(pesanan: Pesanan) {
        TODO("Not yet implemented")
    }

    override suspend fun updatePesanan(pesanan: Pesanan) {
        TODO("Not yet implemented")
    }

    override suspend fun deletePesanan(pesanan: Pesanan) {
        TODO("Not yet implemented")
    }

}