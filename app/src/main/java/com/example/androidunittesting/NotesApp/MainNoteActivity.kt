package com.example.androidunittesting.NotesApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.androidunittesting.R

class MainNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_note)

        val title = findViewById<EditText>(R.id.txt_title)
        val description = findViewById<EditText>(R.id.txt_dec)
        val btnSubmit = findViewById<Button>(R.id.btn_submit)

        btnSubmit.setOnClickListener {
            val msg = "Title - ${title.text} | Desc - ${description.text}"
            val intent = Intent(this,SecondNoteDetailActivity::class.java)
            intent.putExtra("KEY",msg)
            startActivity(intent)
        }
    }
}