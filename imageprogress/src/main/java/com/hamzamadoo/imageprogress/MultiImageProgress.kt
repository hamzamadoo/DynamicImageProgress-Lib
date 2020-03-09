package com.hamzamadoo.imageprogress

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import java.util.*


class MultiImageProgress(context: Context, attrs: AttributeSet) :
    AppCompatImageView(context, attrs) {
    var startOnInit = false
    private var delay = 1000L
    private var period = 1000L

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.MultiImageProgress)

        a.getInt(R.styleable.MultiImageProgress_delay, 1000).toLong().let {
            if (it > 0)
                delay = it
        }
        a.getInt(R.styleable.MultiImageProgress_period, 1000).toLong().let {
            if (it > 0)
                period = it
        }
        startOnInit = a.getBoolean(R.styleable.MultiImageProgress_startOnInit, false)
    }

    val TAG = this@MultiImageProgress::class.java.canonicalName
    private val timer by lazy { Timer() }

    private val timerTask: TimerTask
        get() =
            object : TimerTask() {
                override fun run() {
                    mHandler.post(mainRunnable)
                }

            }

    private val mHandler by lazy {
        Handler(Looper.getMainLooper())
    }

    private val mainRunnable: Runnable by lazy {
        Runnable {
            this.setImageDrawable(ContextCompat.getDrawable(context, allDrawables[counter]))
            counter = if (counter < (allDrawables.size - 1)) (counter + 1) else 0
        }
    }

    private var btDrawable: Int = -1
    private val allDrawables: MutableList<Int> by lazy { mutableListOf<Int>() }
    private lateinit var currentTimerTask: TimerTask

    private var counter: Int = 0

    fun init(drawableIds: List<Int>) {
        btDrawable = drawableIds[0]
        allDrawables.addAll(drawableIds)
        if (startOnInit)
            startProgress()
    }

    fun stopProgress() {
        if (::currentTimerTask.isInitialized) {
            currentTimerTask.cancel()
            timer.purge()
        } else Log.e(TAG, "first call start progress")
    }

    fun startProgress() {
        when {
            allDrawables.size > 1 -> {
                currentTimerTask = timerTask
                timer.scheduleAtFixedRate(currentTimerTask, delay, period)
            }
            allDrawables.size == 1 -> Log.e(TAG, "kindly provide more than one image")
            else -> Log.e(TAG, "kindly provide images")
        }
    }
}