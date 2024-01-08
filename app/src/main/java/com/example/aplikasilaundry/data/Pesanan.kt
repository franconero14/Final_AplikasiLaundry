package com.example.aplikasilaundry.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_pesanan")
data class Pesanan(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nama: String = "",
    val nohp: String = "",
    val alamat: String = "",
    val harga: String = "",
    val wangi: String = ""
)