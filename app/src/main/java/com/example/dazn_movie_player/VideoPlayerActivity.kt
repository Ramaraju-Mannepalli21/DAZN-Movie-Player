package com.example.dazn_movie_player

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dazn_movie_player.databinding.ActivityVideoPlayerBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem


class VideoPlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVideoPlayerBinding
    private var exoPlayer: ExoPlayer? = null
    private var playbackPosition = 0L
    private var playWhenReady = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoPlayerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var  name = intent.getStringExtra("Title")
        var subTitle = intent.getStringExtra("Description")
        val text1: TextView = findViewById(R.id.tvTitle)
        val text2: TextView = findViewById(R.id.tvSubTitle)
        text1.text = name
        text2.text = subTitle
        preparePlayer()
    }

    private fun preparePlayer() {
        exoPlayer = ExoPlayer.Builder(this).build()
        exoPlayer?.playWhenReady = true
        binding.playerView.player = exoPlayer
        val mediaItem = MediaItem.fromUri(VIDEO_URL)
        exoPlayer?.setMediaItem(mediaItem)
        exoPlayer?.seekTo(playbackPosition)
        exoPlayer?.playWhenReady = playWhenReady
        exoPlayer?.prepare()
    }

    private fun relasePlayer() {
        exoPlayer?.let { player ->
            playbackPosition = player.currentPosition
            playWhenReady = player.playWhenReady
            player.release()
            exoPlayer = null

        }

    }

    override fun onStop() {
        super.onStop()
        relasePlayer()
    }

    override fun onPause() {
        super.onPause()
        relasePlayer()
    }

    override fun onDestroy() {
        super.onDestroy()
        relasePlayer()
    }


    companion object {

        const val VIDEO_URL =
            "https://bitdash-a.akamaihd.net/content/MI201109210084_1/m3u8s/f08e80da-bf1d-4e3d-8899-f0f6155f6efa.m3u8"
    }
}