package com.example.dazn_movie_player

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dazn_movie_player.databinding.MovieItemBinding
import com.example.dazn_movie_player.models.Movie


class MovieAdapter(
    private val movies: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/"

        fun bindMovie(movie: Movie) {
            binding.movieTitle.text = movie.title
            binding.movieReleaseDate.text = movie.release
            Glide.with(itemView.context).load(IMAGE_BASE_URL + movie.poster)
                .into(binding.moviePosterIv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies[position])
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, VideoPlayerActivity::class.java)
            startActivity(it.context, intent, null)

        }
    }
}
