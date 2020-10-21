package com.hasan.svga_loader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var data: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_click_me = findViewById<Button>(R.id.button)
        data = findViewById<EditText>(R.id.editTextNumberDecimal)

        btn_click_me.setOnClickListener {
            val intent = Intent(this@MainActivity, SVGAPlayerActivity::class.java)
            intent.putExtra("data", data.text.toString())
            startActivity(intent)
        }

    }
}