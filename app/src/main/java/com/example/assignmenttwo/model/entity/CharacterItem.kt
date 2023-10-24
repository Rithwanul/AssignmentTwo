package com.example.assignmenttwo.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.assignmenttwo.model.response.character.WandResponse
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tbl_character_item")
data class CharacterItem (

    @PrimaryKey
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("ancestry")
    val ancestry: String? = null,

    @field:SerializedName("house")
    val house: String? = null,

    @field:SerializedName("actor")
    val actor: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

)