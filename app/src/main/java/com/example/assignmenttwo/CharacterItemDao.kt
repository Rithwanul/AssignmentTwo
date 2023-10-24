package com.example.assignmenttwo

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assignmenttwo.model.entity.CharacterItem

@Dao
interface CharacterItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacterItem(characterItem: CharacterItem)

    @Query("SELECT * from tbl_character_item")
    fun getCharacters(): List<CharacterItem>
}