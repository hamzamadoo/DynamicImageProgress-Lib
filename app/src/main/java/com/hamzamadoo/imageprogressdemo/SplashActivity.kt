package com.hamzamadoo.imageprogressdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    private val avengers by lazy {
        listOf(R.drawable.caiptan_america,R.drawable.hulk,R.drawable.ant_man,
            R.drawable.groot,R.drawable.iron_man)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        imgAvengers.init(avengers)
        imgAvengers.startProgress()
    }
}
