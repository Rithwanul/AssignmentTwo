package com.example.assignmenttwo.di.module

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignmenttwo.adapter.CharacterAdapter
import dagger.Module
import dagger.Provides


@Module
class AdapterModule {

//    @Provides
//    fun provideLinearLayoutManager(context: Context) = LinearLayoutManager(context)

    @Provides
    fun provideCharacterAdapter(context: Context) = CharacterAdapter(context)
}