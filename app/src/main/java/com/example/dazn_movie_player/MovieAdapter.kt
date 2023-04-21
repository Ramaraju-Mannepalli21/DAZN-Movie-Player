package com.example.dazn_movie_player

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dazn_movie_player.models.Movie


class MovieAdapter(
    private val movies : List<Movie>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

        private lateinit var movieTitleTv:TextView
        private lateinit var movieReleaseDateTv:TextView
         lateinit var moviePosterIv:ImageView


        fun bindMovie(movie : Movie){
            movieTitleTv=itemView.findViewById(R.id.movie_title)
            movieTitleTv.text=movie.title

            movieReleaseDateTv=itemView.findViewById(R.id.movie_release_date)
            movieReleaseDateTv.text=movie.release

            moviePosterIv = itemView.findViewById(R.id.movie_poster_iv)



            Glide.with(itemView.context).load(IMAGE_BASE + movie.poster).into(moviePosterIv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
//        holder.moviePosterIv
    }
}