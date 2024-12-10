package com.slaiman.sobercare

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.slaiman.sobercare.ui.theme.SoberCareTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainpagelayout)

        val welcome_msg: TextView = findViewById(R.id.main_welcome_msg)

        val fade_in = AnimationUtils.loadAnimation(this, R.anim.welcome_fade_in)
        val fade_out = AnimationUtils.loadAnimation(this, R.anim.welcome_fade_out)

        welcome_msg.isEnabled = true
        welcome_msg.visibility = TextView.VISIBLE
        welcome_msg.startAnimation(fade_in)

        fade_in.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                // Start fade-out animation after fade-in ends
                welcome_msg.startAnimation(fade_out)

            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })

        fade_out.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                welcome_msg.visibility = TextView.GONE
                welcome_msg.isEnabled = false

                val intent = Intent(this@MainActivity, UserPromptActivity::class.java)
                startActivity(intent)
                finish()

            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })


    }
}

