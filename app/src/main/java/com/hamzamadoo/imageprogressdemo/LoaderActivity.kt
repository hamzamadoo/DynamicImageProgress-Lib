package com.hamzamadoo.imageprogressdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_loader.*

class LoaderActivity : AppCompatActivity() {

    private val food =
        listOf(
            R.drawable.coffee,
            R.drawable.hotdog, R.drawable.pizza, R.drawable.sandwich, R.drawable.soda,
            R.drawable.burger
        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loader)
        supportActionBar?.title = "Order Details"
        imgProgress.init(food)
    }
}
