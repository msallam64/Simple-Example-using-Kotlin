package com.example.kotlintask.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.kotlintask.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startBtn = findViewById<Button>(R.id.button)
        startBtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AnswerQuestionActivity::class.java)
            startActivity(intent)
        })


    }
}