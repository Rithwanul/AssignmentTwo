package com.example.assignmenttwo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.assignmenttwo.CharacterItemDao
import com.example.assignmenttwo.model.entity.CharacterItem

@Database(
    entities = [
        CharacterItem::class,
    ],
    version = AppDatabase.version,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val version: Int = 1
        private const val databaseName: String = "CHARACTER-DB"

        private var INSTANCE: AppDatabase? = null

        fun getDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, databaseName)
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE
        }
    }

    abstract fun getCharacterItemDAO(): CharacterItemDao
}