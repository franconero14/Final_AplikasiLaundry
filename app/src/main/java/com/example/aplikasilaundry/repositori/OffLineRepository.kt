package com.example.aplikasilaundry.repositori

import com.example.aplikasilaundry.data.Pesanan
import com.example.aplikasilaundry.data.PesananDao
import kotlinx.coroutines.flow.Flow

class OffLineRepository(private val pesananDao: PesananDao) : PesananRepository {
    override fun getAllPesananStream(): Flow<List<Pesanan>> {
        return pesananDao.getAllPesanan()
    }

    override fun getPesananStream(id: Int): Flow<Pesanan?> {
        return pesananDao.getPesanan(id)
    }

    override suspend fun insertPesanan(pesanan: Pesanan) {
        return pesananDao.insert(pesanan)
    }

    override suspend fun updatePesanan(pesanan: Pesanan) {
        return pesananDao.update(pesanan)
    }

    override suspend fun deletePesanan(pesanan: Pesanan) {
        return pesananDao.delete(pesanan)
    }

}