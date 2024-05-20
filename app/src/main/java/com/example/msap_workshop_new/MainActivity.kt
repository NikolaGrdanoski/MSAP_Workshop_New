package com.example.msap_workshop_new

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.loader.app.LoaderManager
import androidx.loader.content.AsyncTaskLoader
import java.lang.reflect.Member
import java.net.URL
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn: Button = findViewById(R.id.btn) //inicijalizirame kopce

        btn.setOnClickListener{
            var random: Int? //nullable broj generirame
            Thread.sleep(7000)
            random = Random.nextInt(0, 3)
            if (random == 0) {
                random = null
                Toast.makeText(this, "Null $random", Toast.LENGTH_SHORT).show()
            }
            else if (random == 1) {
                UI.Success(true) //ako brojot e 1, imame uspeh i se zapisuva
                val success = UI.Success(true)
                Toast.makeText(this, "Success $success", Toast.LENGTH_SHORT).show()
            }
            else {
                UI.Error(true) //ako brojot e 2, imame neuspeh i se zapisuva
                val error = UI.Error(true)
                Toast.makeText(this, "Error $error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

sealed class UI{
    data class Success(
        val isTrue: Boolean
    )
    data class Error(
        val isTrue: Boolean
    )
}