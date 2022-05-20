package com.example.otpmobile.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.otpmobile.R

class StoreAdaptor(private val itemsStore : ArrayList<String>) : RecyclerView.Adapter<StoreAdaptor.MainViewHolder>() {

    inner class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {

        fun bindData(itemsStore: ArrayList<String>){
            val name = itemView.findViewById<TextView>(R.id.text_shopByStore)
            name.text = itemsStore[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.store_elememts , parent ,false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        return holder.bindData(itemsStore)
    }

    override fun getItemCount(): Int {
        return itemsStore.size
    }


}