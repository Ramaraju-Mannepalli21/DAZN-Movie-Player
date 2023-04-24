package com.example.dazn_movie_player

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dazn_movie_player.databinding.MovieItemBinding
import com.example.dazn_movie_player.models.Tile


class DaznTilesAdapter(
    private val tiles: List<Tile>?
) : RecyclerView.Adapter<DaznTilesAdapter.MovieViewHolder>() {

    class MovieViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindMovie(tile: Tile) {
            binding.movieTitle.text = tile.title
            binding.movieReleaseDate.text = tile.description
            Glide.with(itemView.context).load("https://image.discovery.indazn.com/jp/v3/jp/none/111573061664_image-header_pRow_1620538817000/fill/center/top/none/85/1042/828/jpg/image")
                .into(binding.moviePosterIv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = tiles?.size ?: 0

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(tiles!![position])
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, VideoPlayerActivity::class.java)
            startActivity(it.context, intent, null)

        }
    }
}
