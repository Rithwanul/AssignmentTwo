package com.example.assignmenttwo.viewmodel

import androidx.lifecycle.ViewModel
import com.example.assignmenttwo.service.NetworkService
import com.google.gson.Gson
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterViewModel @Inject constructor(

    private val networkService: NetworkService,
    private val gson: Gson
) : ViewModel(){

    fun getAllCharacter() = flow {
        val allCharacters = networkService.getAllCharacters()
        emit(allCharacters)
    }
}