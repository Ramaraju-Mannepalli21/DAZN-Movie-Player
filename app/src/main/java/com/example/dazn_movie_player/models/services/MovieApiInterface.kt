package com.example.dazn_movie_player.models.services

import com.example.dazn_movie_player.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=ae3e51a2cc95161ed1c94b4e989ed9f7")
    fun getMovieList(): Call<MovieResponse>
}