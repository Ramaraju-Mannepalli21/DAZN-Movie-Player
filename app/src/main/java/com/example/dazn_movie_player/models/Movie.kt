package com.example.dazn_movie_player.models


import com.google.gson.annotations.SerializedName



data class Movie(
    @SerializedName("id") val id: String?,

    @SerializedName("title") val title: String?,

    @SerializedName("poster_path") var poster: String?,

    @SerializedName("release_date") var release: String?

)


