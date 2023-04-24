package com.example.dazn_movie_player.models


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("Id")
    var id: String?,
    @SerializedName("ImageMimeType")
    var imageMimeType: String?,
    @SerializedName("ImageType")
    var imageType: String?
)