package com.example.dazn_movie_player.models


import com.google.gson.annotations.SerializedName

data class Video(
    @SerializedName("Format")
    var format: String?,
    @SerializedName("Id")
    var id: String?
)