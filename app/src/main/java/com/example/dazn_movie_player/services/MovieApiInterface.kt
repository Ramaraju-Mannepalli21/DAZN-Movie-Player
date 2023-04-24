package com.example.dazn_movie_player.services

import com.example.dazn_movie_player.models.DaznTilesResponse
import com.example.dazn_movie_player.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    companion object {
        const val API_KEY = "/3/movie/popular?api_key=ae3e51a2cc95161ed1c94b4e989ed9f7"
        const val DAZN_ENDPOINT = "/v1/5a8dbd14-6eba-4697-9027-56b0b3efd9dc"
    }

    @GET(API_KEY)
    fun getMovieList(): Call<MovieResponse>
    @GET(DAZN_ENDPOINT)
    fun getMatches(): Call<DaznTilesResponse>
}