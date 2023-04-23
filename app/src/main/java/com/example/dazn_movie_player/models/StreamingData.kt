package com.example.dazn_movie_player.models

import com.google.gson.annotations.SerializedName

data class StreamingData(
    @SerializedName("Id") var Id: String? = null,
    @SerializedName("Title") var Title: String? = null,
    @SerializedName("Params") var Params: String? = null,
    @SerializedName("Tiles") var Tiles: ArrayList<Tiles> = arrayListOf(),
    @SerializedName("StartPosition") var StartPosition: Int? = null,
    @SerializedName("ContinuousPlayEnabled") var ContinuousPlayEnabled: Boolean? = null,
    @SerializedName("Navigation") var Navigation: String? = null,
    @SerializedName("Type") var Type: String? = null,
    @SerializedName("Description") var Description: String? = null

)