package com.hamzamadoo.imageprogressdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_progress.*

class ProgressActivity : AppCompatActivity() {

    private val food by lazy {
        listOf(
            R.drawable.coffee,
            R.drawable.hotdog, R.drawable.pizza, R.drawable.sandwich, R.drawable.soda,
            R.drawable.burger
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)
        imgProgress.init(food)
    }
}
