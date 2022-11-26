package gst.trainingcourse.recyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager


    private var layoutManager : RecyclerView.LayoutManager ?= null
    private var adapter       : RecyclerView.Adapter<RecycleAdapter.ViewHolder>? = null
    lateinit var recyclerView : RecyclerView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        layoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = layoutManager
        adapter = RecycleAdapter()
        recyclerView.adapter = adapter

    }

}