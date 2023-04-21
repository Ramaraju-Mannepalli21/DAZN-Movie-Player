package com.example.dazn_movie_player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dazn_movie_player.models.Movie
import com.example.dazn_movie_player.models.MovieResponse
import com.example.dazn_movie_player.models.services.MovieApiInterface
import com.example.dazn_movie_player.models.services.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var mListRecyclerView: RecyclerView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mListRecyclerView = findViewById(R.id.rv_movies_list)
        mListRecyclerView.layoutManager = LinearLayoutManager(this)
        getMovieData { movies: List<Movie> ->
            mListRecyclerView.adapter = MovieAdapter(movies)
        }
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(
                    applicationContext, t.localizedMessage, Toast.LENGTH_LONG
                ).show()
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful)
                    return callback(response.body()!!.movies)
            }
        })
    }
}