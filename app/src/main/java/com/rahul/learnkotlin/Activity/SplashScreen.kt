package com.rahul.learnkotlin.Activity

import android.app.ActionBar
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.postDelayed
import androidx.recyclerview.widget.RecyclerView
import com.rahul.learnkotlin.R

class SplashScreen : AppCompatActivity() {

    lateinit var icon:ImageView
    lateinit var logo:TextView
    var animation:Animation?=null
    private val TIME:Long=5000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        animation = AnimationUtils.loadAnimation(this, R.anim.top_anim)
        icon = findViewById(R.id.kotlinicon)
        logo = findViewById(R.id.logo)
        icon.startAnimation(animation)
        logo.startAnimation(animation)
//                hide the status bar
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        Handler().postDelayed({

            startActivity(Intent(this,MainActivity::class.java))

            finish()
        }, TIME)
    }

}