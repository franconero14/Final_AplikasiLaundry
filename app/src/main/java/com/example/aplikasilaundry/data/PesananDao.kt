package com.example.aplikasilaundry.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface PesananDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pesanan: Pesanan)
}