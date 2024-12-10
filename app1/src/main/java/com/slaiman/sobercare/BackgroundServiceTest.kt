package com.slaiman.sobercare

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.widget.Toast

class BackgroundServiceTest : Service() {
    private val handler = Handler()
    private var runnable: Runnable? = null

    override fun onCreate() {
        super.onCreate()
        // Create a runnable that will display a Toast every second
        runnable = object : Runnable {
            override fun run() {
                // Show a toast message
                Toast.makeText(applicationContext, "Injecting...", Toast.LENGTH_SHORT).show()

                // Schedule the next toast after 1 second (1000 ms)
                handler.postDelayed(this, 5000)
            }
        }
        handler.post(runnable!!)
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        // Keep the service running in the background
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        // Remove the callback to stop the toasts when service is destroyed
        handler.removeCallbacks(runnable!!)
    }
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }


}