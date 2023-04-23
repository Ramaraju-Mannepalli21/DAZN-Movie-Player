package com.example.dazn_movie_player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dazn_movie_player.models.Movie
import com.example.dazn_movie_player.models.MovieResponse
import com.example.dazn_movie_player.models.Tile
import com.example.dazn_movie_player.models.services.MovieApiInterface
import com.example.dazn_movie_player.models.services.MovieApiService
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


class MainActivity : AppCompatActivity() {



    private lateinit var mListRecyclerView: RecyclerView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mListRecyclerView = findViewById(R.id.rv_movies_list)
        mListRecyclerView.layoutManager = LinearLayoutManager(this)
        loadTilesFromJson()

    }
    private fun loadTilesFromJson() {
        var jsonString = ""
        try {
            jsonString = this.assets.open("tiles.json")
                .bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            // Handle exception
        }
        val jsonObject = JSONObject(jsonString)
        val ja_data: JSONArray = jsonObject.getJSONArray("Tiles")
        val listdata = ArrayList<Tile>()
        if (ja_data != null) {
            for (i in 0 until ja_data.length()) {
                listdata.add(Tile(
                    ja_data.getJSONObject(i).getString("Title"),
                    ja_data.getJSONObject(i).getString("Description"),
                    ja_data.getJSONObject(i).getString("Url")
                ))
            }
        }
        mListRecyclerView.adapter = TileAdapter(listdata)
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
                if (response.isSuccessful) return callback(response.body()!!.movies)
            }
        })
    }

}