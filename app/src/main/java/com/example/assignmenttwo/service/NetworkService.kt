package com.example.assignmenttwo.service

import com.example.assignmenttwo.model.response.character.CharacterItemResponse
import retrofit2.http.GET

interface NetworkService {

    companion object{
        const val BASE_URL: String = "https://hp-api.onrender.com/api/"
    }

    @GET("characters")
    suspend fun getAllCharacters(): List<CharacterItemResponse>
}