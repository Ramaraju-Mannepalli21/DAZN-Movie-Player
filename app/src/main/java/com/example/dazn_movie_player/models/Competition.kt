package com.example.dazn_movie_player.models

import com.google.gson.annotations.SerializedName

data class Competition(

    @SerializedName("Id") var Id: String? = null,
    @SerializedName("Title") var Title: String? = null

)