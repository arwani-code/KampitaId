package com.picodiploma.kampitaid.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.picodiploma.kampitaid.data.local.entity.QuakeEntity

@Database(entities = [QuakeEntity::class], version = 1, exportSchema = false)
abstract class QuakeDatabase: RoomDatabase() {

    abstract fun quakeDao(): QuakeDao

    companion object {
        @Volatile
        private var instance: QuakeDatabase? = null
        fun getInstance(context: Context): QuakeDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    QuakeDatabase::class.java,
                    "Quake.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { instance = it }
            }
    }
}