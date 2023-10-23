package com.example.assignmenttwo.model.response.character

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Wand(
	@SerializedName("wood"   ) var wood   : String? = null,
	@SerializedName("core"   ) var core   : String? = null,
	@SerializedName("length" ) var length : Double?    = null
) : Parcelable