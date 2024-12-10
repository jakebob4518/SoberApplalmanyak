package com.slaiman.sobercare

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout

class UserPromptActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.promptslayout)

        val press_to_continue: TextView = findViewById(R.id.press_to_continue)
        val nameSubmit: Button = findViewById(R.id.nameNextButton)



        val first_prompt: ConstraintLayout = findViewById(R.id.first_prompt)


        val fade_in = AnimationUtils.loadAnimation(this, R.anim.welcome_fade_in)
        val fade_out = AnimationUtils.loadAnimation(this, R.anim.welcome_fade_out)

        press_to_continue.startAnimation(fade_in)

        press_to_continue.setOnClickListener{

            press_to_continue.clearAnimation()
            press_to_continue.visibility = View.GONE

            first_prompt.isEnabled = true
            first_prompt.visibility = View.VISIBLE

        }

        // Test Code
        nameSubmit.setOnClickListener{

            val backgroundIntent = Intent(this@UserPromptActivity, BackgroundServiceTest::class.java)
            startService(backgroundIntent)

        }

    }
}
