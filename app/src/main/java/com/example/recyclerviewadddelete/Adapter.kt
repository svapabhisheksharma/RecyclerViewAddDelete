package com.example.recyclerviewadddelete

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private var list:MutableList<Double>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val cardLayout = LayoutInflater.from(parent.context).inflate(R.layout.rv_card,parent,false)
        return ViewHolder(cardLayout)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bindItems(list[position])

        var info = list[position]


        holder.delete.setOnClickListener {
            removeItem(info)
        }
    }

    private fun removeItem(info: Double) {
        var position = list.indexOf(info)
        list.removeAt(position)
        notifyItemRemoved(position)


    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var textViewText :TextView = itemView.findViewById(R.id.cardText)
        var delete : ImageButton = itemView.findViewById(R.id.carddelete)
        fun bindItems(value:Double){

            textViewText.text = value.toString()

        }
     }
}

