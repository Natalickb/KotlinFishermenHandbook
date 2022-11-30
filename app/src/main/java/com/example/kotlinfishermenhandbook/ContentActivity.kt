package com.example.kotlinfishermenhandbook

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_layout.*

class ContentActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)
        tvTitle2.text = intent.getStringExtra("title")
        textView3.text = intent.getStringExtra("content")
        im2.setImageResource(intent.getIntExtra("image",R.drawable.caras))
    }
}