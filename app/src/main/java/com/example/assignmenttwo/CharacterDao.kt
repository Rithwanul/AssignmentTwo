package com.example.assignmenttwo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assignmenttwo.model.entity.Character

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacterItem(characterItem: Character)

    @Query("SELECT * from tbl_character")
    fun getCharacters(): List<Character>
}