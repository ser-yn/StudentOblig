package com.example.studentoblig.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentoblig.R
import com.example.studentoblig.model.Animal

//This is the adapter which gets the data from our datasource into the Recycler view
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Animal>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    //Since viewHolder is only used inside ItemAdapter, we can make it nested to show that relationship
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    //Creates new view holder when there are none to reuse, one ViewHolder represents a single list Item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    //Replaces the content of a listItem view
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    override fun getItemCount() = dataset.size
}