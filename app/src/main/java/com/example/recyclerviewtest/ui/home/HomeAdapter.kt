package com.example.recyclerviewtest.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtest.R
import com.example.recyclerviewtest.models.Item
import com.example.recyclerviewtest.models.RepoResult

class HomeAdapter(private val emplist: RepoResult, private val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    interface OnItemClickListener {
        fun onClick(item: Item)
    }

    // This method creates a new ViewHolder object for each item in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate the layout for each item and return a new ViewHolder object
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.items_list, parent, false)
        return MyViewHolder(itemView)
    }

    // This method returns the total
    // number of items in the data set
    override fun getItemCount(): Int {
        return emplist.items.size
    }

    // This method binds the data to the ViewHolder object
    // for each item in the RecyclerView
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentEmp = emplist.items[position]
        holder.name.text = currentEmp.name
        holder.email.text = currentEmp.description
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(currentEmp)
        }
    }

    // This class defines the ViewHolder object for each item in the RecyclerView
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvName)
        val email: TextView = itemView.findViewById(R.id.tvEmail)
    }
}