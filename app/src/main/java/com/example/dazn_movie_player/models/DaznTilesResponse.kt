package com.example.dazn_movie_player.models


import com.google.gson.annotations.SerializedName

data class DaznTilesResponse(
    @SerializedName("ContinuousPlayEnabled")
    var continuousPlayEnabled: Boolean?,
    @SerializedName("Description")
    var description: Any?,
    @SerializedName("Id")
    var id: String?,
    @SerializedName("Navigation")
    var navigation: Any?,
    @SerializedName("Params")
    var params: Any?,
    @SerializedName("StartPosition")
    var startPosition: Int?,
    @SerializedName("Tiles")
    var tiles: List<Tile>?,
    @SerializedName("Title")
    var title: String?,
    @SerializedName("Type")
    var type: String?
)