package com.example.assignmenttwo.service

import com.example.assignmenttwo.model.response.character.CharacterItemResponse
import com.example.assignmenttwo.model.response.characterdetails.CharacterDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkService {

    companion object{
        const val BASE_URL: String = "https://hp-api.onrender.com/api/"
    }

    @GET("characters")
    suspend fun getAllCharacters(): List<CharacterItemResponse>

    @GET("character/{id}")
    suspend fun getCharacterDetailsById(
        @Path("id") id: String
    ): List<CharacterDetailsResponse>
}