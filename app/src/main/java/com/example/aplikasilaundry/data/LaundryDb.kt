package com.example.aplikasilaundry.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi

@Database(entities = [Pesanan::class], version = 1, exportSchema = false)
abstract class LaundryDb : RoomDatabase() {
    abstract fun pesananDao(): PesananDao

    companion object {
        @Volatile
        private var Instance: LaundryDb? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): LaundryDb {
            return (Instance ?: kotlinx.coroutines.internal.synchronized(this) {
                Room.databaseBuilder(context, LaundryDb::class.java, "laundry_db").build()
                    .also { Instance = it }
            })
        }
    }
}