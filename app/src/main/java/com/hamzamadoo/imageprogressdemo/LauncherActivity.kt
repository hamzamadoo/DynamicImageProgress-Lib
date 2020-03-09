package com.hamzamadoo.imageprogressdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
    }

    fun launchSplash(view: View) {
        startActivity(Intent(this, SplashActivity::class.java))
    }

    fun launchLoader(view: View) {
        startActivity(Intent(this, LoaderActivity::class.java))
    }

    fun launchProgressLoader(view: View) {
        startActivity(Intent(this, ProgressActivity::class.java))
    }
}
