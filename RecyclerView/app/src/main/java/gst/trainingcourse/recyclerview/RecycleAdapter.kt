package gst.trainingcourse.recyclerview

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition

class RecycleAdapter : RecyclerView.Adapter<RecycleAdapter.ViewHolder>(){

    private var title = arrayOf("Chapter 1", "Chapter 2", "Chapter 3", "Chapter 4", "Chapter 5", "Chapter 6", "Chapter 7", "Chapter 8", )
    private  var details = arrayOf("Item 1", "Item 1", "Item 1", "Item 1", "Item 1", "Item 1", "Item 1", "Item 1", )
    private  val images = intArrayOf(R.drawable.picture1, R.drawable.img, R.drawable.picture1, R.drawable.picture1, R.drawable.picture1, R.drawable.picture1,
        R.drawable.picture1, R.drawable.picture1 )



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :RecycleAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return title.size
    }
    override fun onBindViewHolder(holder : ViewHolder, position: Int){
        holder.itemTitle.text = title[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var itemImage : ImageView
        var itemTitle : TextView
        var itemDetail : TextView
        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener {
                val position : Int = adapterPosition
                Toast.makeText(itemView.context, "you click on ${title[position]}", Toast.LENGTH_LONG).show()
            }

        }
    }
}