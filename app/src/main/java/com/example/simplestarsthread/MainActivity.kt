package com.example.simplestarsthread

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    lateinit var playy:Button
    lateinit var textView: TextView
    lateinit var imageView: ImageView
    var x=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playy = findViewById(R.id.play)

        textView = findViewById(R.id.textView)
        imageView = findViewById(R.id.imageView)

        runBlocking {

            playy.setOnClickListener {

                //run first thread count ++
                GlobalScope.launch (Dispatchers.Main) {
                    for (i in 1 until 1000000)
                    {

                        delay(1000)
                        textView.text = "Goaaaaaaaal : $i"
                    }

                }

                //run second thread rotate image

                GlobalScope.launch  {
                    for (i in x until 10000000)
                    {
                        delay(10)

                        imageView.setRotation(x++.toFloat());

                    }

                }

            }


        }


    }

}
