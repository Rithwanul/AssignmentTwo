package com.example.assignmenttwo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmenttwo.service.NetworkService
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import timber.log.Timber
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