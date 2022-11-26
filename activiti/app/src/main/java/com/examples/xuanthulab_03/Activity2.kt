package com.examples.xuanthulab_03

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Activity2 : AppCompatActivity() {

    companion object {
        const val travetuact2: Int = 1000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity2)
        val editText = findViewById<EditText>(R.id.edittext2)
        val button2 = findViewById<Button>(R.id.button2)
        val i: Intent = intent
        val dulieu: String? = i.getStringExtra("dulieu")
        editText.setText(dulieu)
        button2.setOnClickListener {
            val intent2 = Intent()
            val s1: String = editText.text.toString()
            intent2.putExtra("dulieu", s1)
            setResult(travetuact2, intent2)
            finish()
        }

    }


}