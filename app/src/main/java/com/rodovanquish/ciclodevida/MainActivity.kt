package com.rodovanquish.ciclodevida

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.botonCheck).setOnClickListener {
            startActivity(Intent(this,Dialog::class.java))
        }

        Log.i("ciclo de vida de una app", "OnCreate")
    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this,R.raw.musica)
        Log.i("ciclodevida","OnStart")
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.seekTo(position)
        mediaPlayer?.start()
        Log.i("ciclodevida","onResume")
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
        if (mediaPlayer != null)
            position = mediaPlayer!!.currentPosition
        Log.i("ciclodevida","onPause")
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        Log.i("ciclodevida","onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ciclodevida","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ciclodevida","onDestroy")
    }
}