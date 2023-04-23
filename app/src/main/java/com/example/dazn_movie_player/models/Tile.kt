package com.example.dazn_movie_player.models

import com.google.gson.annotations.SerializedName

data class Tile (
    @SerializedName("Title") var Title: String? = null,
    @SerializedName("Description") var Description: String? = null,
    @SerializedName("Url") var Url:String? =null
)
