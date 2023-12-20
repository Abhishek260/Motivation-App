package com.example.demoswiggy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demoswiggy.databinding.ActivityMainBinding
import com.example.demoswiggy.quotesSection.QuotesActivity


class MainActivity : AppCompatActivity() {
    private lateinit var activityBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)

        onClicks()
    }

    private fun onClicks() {
//        activityBinding.testing.setOnClickListener {
//            var demoIntent = Intent(this, DemoActivity::class.java)
//            startActivity(demoIntent)
//        }
        activityBinding.quoteBtn.setOnClickListener {
            val intent = Intent(this, QuotesActivity::class.java)
            startActivity(intent)
        }
    }

}