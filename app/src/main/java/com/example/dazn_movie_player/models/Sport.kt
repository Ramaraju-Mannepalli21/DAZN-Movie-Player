package com.example.dazn_movie_player.models


import com.google.gson.annotations.SerializedName

data class Sport(
    @SerializedName("Id")
    var id: String?,
    @SerializedName("Images")
    var images: List<Image>?,
    @SerializedName("Title")
    var title: String?
)