package com.example.aplikasilaundry.ui.model

import com.example.aplikasilaundry.data.Pesanan


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

fun Pesanan.toDetailLaundry(): DetailLaundry = DetailLaundry(
    id = id,
    nama = nama,
    nohp = nohp,
    alamat = alamat,
    harga = harga,
    wangi = wangi
)