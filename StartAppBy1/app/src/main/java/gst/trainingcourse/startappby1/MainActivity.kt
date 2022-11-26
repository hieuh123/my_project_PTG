 package gst.trainingcourse.startappby1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnFace.setOnClickListener(){
            faceBookButton()
        }

    }



    fun faceBookButton() {
        //val intent : Intent? = packageManager.getLaunchIntentForPackage("com.google.android.youtube")
        intent=Intent()

        if(intent != null){
            startActivity(intent)
        }
    }


 }