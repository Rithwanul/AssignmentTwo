package com.example.assignmenttwo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber
import javax.inject.Inject

class CharacterViewModel @Inject constructor(

) : ViewModel(){

    init {
        Timber.tag("Data").v("ViewModel Initialize")
    }

    fun getName(): String {
        return "dico"
    }
}