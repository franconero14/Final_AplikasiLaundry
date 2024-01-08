package com.example.aplikasilaundry.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
interface PesananDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pesanan: Pesanan)

    @Update
    suspend fun update(pesanan: Pesanan)

    @Delete
    suspend fun  delete(pesanan: Pesanan)
}
