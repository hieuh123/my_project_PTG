package com.examples.xuanthulab_03

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class Activity1 : AppCompatActivity() {
    private lateinit var textView1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity1)

        textView1 = findViewById<EditText>(R.id.textview1)
        val button1 = findViewById<Button>(R.id.button1)

        button1.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            //startActivity(intent)

            val s: String = textView1.text.toString()
            intent.putExtra("dulieu", s)
            //startActivity(intent)
            startActivityForResult(intent, Activity2.travetuact2)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Activity2.travetuact2) {
            val s3: String? = data!!.getStringExtra("dulieu")
            textView1.setText(s3)
        }
    }

}