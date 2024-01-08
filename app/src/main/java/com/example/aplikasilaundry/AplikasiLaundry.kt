package com.example.aplikasilaundry

import android.app.Application
import com.example.aplikasilaundry.repositori.ContainerData
import com.example.aplikasilaundry.repositori.DataContainer

class AplikasiLaundry : Application() {
    lateinit var dataContainer: DataContainer

    override fun onCreate() {
        super.onCreate()
        dataContainer = ContainerData(this)
    }
}