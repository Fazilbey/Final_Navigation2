package com.example.navigationproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(var con: Context, var list: List<UsersItem>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v){
       var url_link = v.findViewById<TextView>(R.id.url)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(con).inflate(R.layout.list_of_links,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.url_link.text = list[position].url
    }
}