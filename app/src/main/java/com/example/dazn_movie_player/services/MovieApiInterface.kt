package com.example.dazn_movie_player.services

import com.example.dazn_movie_player.models.DaznTilesResponse
import com.example.dazn_movie_player.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    companion object {
        const val API_KEY = "/3/movie/popular?api_key=ae3e51a2cc95161ed1c94b4e989ed9f7"
        const val DAZN_ENDPOINT = "/v1/fc2a4463-16e1-4a03-acdd-12abe4b8300a"
    }

    @GET(API_KEY)
    fun getMovieList(): Call<MovieResponse>

    @GET(DAZN_ENDPOINT)
    fun getMatches(): Call<DaznTilesResponse>
}