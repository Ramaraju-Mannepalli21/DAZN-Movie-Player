package com.example.dazn_movie_player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dazn_movie_player.models.DaznTilesResponse
import com.example.dazn_movie_player.models.Tile
import com.example.dazn_movie_player.services.MovieApiInterface
import com.example.dazn_movie_player.services.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var ivMenu: ImageView
    private lateinit var mListRecyclerView: RecyclerView;
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    var isDrawerOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.my_drawer_layout)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mListRecyclerView = findViewById(R.id.rv_movies_list)
        mListRecyclerView.layoutManager = GridLayoutManager(this, 2)
        getMatches { tiles: List<Tile>? ->
            mListRecyclerView.adapter = DaznTilesAdapter(tiles)
        }
        ivMenu = findViewById(R.id.ivMenu)
        ivMenu.setOnClickListener {
            isDrawerOpen = !isDrawerOpen
            if (isDrawerOpen)
                drawerLayout.openDrawer(GravityCompat.START)
            else
                drawerLayout.closeDrawer(GravityCompat.START)
        }
    }

    private fun getMatches(callback: (List<Tile>?) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMatches().enqueue(object : Callback<DaznTilesResponse> {
            override fun onResponse(
                call: Call<DaznTilesResponse>,
                response: Response<DaznTilesResponse>
            ) {
                Log.i("msg", response.toString())
                if (response.isSuccessful)
                    return callback(response.body()!!.tiles)
            }

            override fun onFailure(call: Call<DaznTilesResponse>, t: Throwable) {
                Toast.makeText(
                    applicationContext, t.localizedMessage, Toast.LENGTH_LONG
                ).show()
            }

        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }
}

