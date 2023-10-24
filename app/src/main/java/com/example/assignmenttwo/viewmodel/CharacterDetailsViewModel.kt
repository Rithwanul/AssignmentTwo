package com.example.assignmenttwo.viewmodel

import androidx.lifecycle.ViewModel
import com.example.assignmenttwo.database.config.AppDatabase
import com.example.assignmenttwo.service.NetworkService
import com.google.gson.Gson
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterDetailsViewModel @Inject constructor(

    private val networkService: NetworkService,
    private val gson: Gson,
    private val appDatabase: AppDatabase
) : ViewModel(){


//    fun getAllCharacter(id: String) = flow {
//        val allCharacters = networkService.getAllCharacters()
//        emit(networkService.getCharacterDetailsById(id))
//    }

    suspend fun getAllCharacter(id: String) = networkService.getCharacterDetailsById(id)
}