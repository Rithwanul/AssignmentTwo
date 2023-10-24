package com.example.assignmenttwo.di.module

import android.content.Context
import com.example.assignmenttwo.CharacterDao
import com.example.assignmenttwo.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): AppDatabase = AppDatabase.getDataBase(context)!!

    @Singleton
    @Provides
    fun provideCharacterItemDAO(appDatabase: AppDatabase): CharacterDao = appDatabase.getCharacterItemDAO()
}