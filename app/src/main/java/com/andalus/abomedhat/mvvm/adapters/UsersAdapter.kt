package com.andalus.abomedhat.mvvm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andalus.abomedhat.mvvm.R
import com.andalus.abomedhat.mvvm.models.User
import kotlinx.android.synthetic.main.user_item.view.*

class UsersAdapter(var data: MutableList<User> = mutableListOf()) :
    RecyclerView.Adapter<UsersAdapter.UserHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false))
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.tvName.text = data[position].name
        holder.tvId.text = "${data[position].id}"
        holder.tvEmail.text = data[position].email
        holder.tvPhone.text = data[position].phone
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class UserHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = itemView.tvName
        val tvId: TextView = itemView.tvId
        val tvEmail: TextView = itemView.tvEmail
        val tvPhone: TextView = itemView.tvPhone
    }
}