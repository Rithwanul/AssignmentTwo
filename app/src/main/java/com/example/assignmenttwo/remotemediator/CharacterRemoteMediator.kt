package com.example.assignmenttwo.remotemediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.assignmenttwo.database.config.AppDatabase
import com.example.assignmenttwo.database.dao.CharacterDao
import com.example.assignmenttwo.model.entity.Character
import com.example.assignmenttwo.service.NetworkService

@OptIn(ExperimentalPagingApi::class)
class CharacterRemoteMediator(
    private val appDatabase: AppDatabase,
    private val networkService: NetworkService
): RemoteMediator<Int, Character>() {


    private val characterDao: CharacterDao = appDatabase.getCharacterItemDAO()
    private val characters: MutableList<Character> = mutableListOf()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Character>
    ): MediatorResult {

        val countCharacter = characterDao.isCharacterAvailable()

        if (countCharacter == 0) {
            val result = networkService.getAllCharacters()

            result.forEach { item ->
                item.id?.let {
                    Character(
                        it,
                        item.image,
                        item.ancestry,
                        item.house,
                        item.actor,
                        item.name
                    )
                }?.let { characters.add(it) }
            }

            appDatabase.withTransaction {
                characterDao.insertCharacters(characters)
            }
        }
        return MediatorResult.Success(true)
    }
}