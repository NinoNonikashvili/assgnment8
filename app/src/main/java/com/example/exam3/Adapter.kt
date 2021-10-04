package com.example.exam3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(private val contentsList: MutableList<User>, private val click: (position: Int) -> User?): RecyclerView.Adapter<Adapter.myViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = myViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false), click)


    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val user:User = contentsList.get(position)
        holder.name.setText(user.name)
        holder.lastname.setText(user.lastname)
        holder.email.setText(user.email)
    }

    override fun getItemCount() = contentsList.size
    inner class myViewHolder(itemView: View, private val click: (position:Int)->User?) :RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val name = itemView.findViewById<TextView>(R.id.name)
        val lastname =itemView.findViewById<TextView>(R.id.lastname)
        val email = itemView.findViewById<TextView>(R.id.email)
        init {
            itemView.findViewById<Button>(R.id.delete).setOnClickListener(this)
            itemView.findViewById<Button>(R.id.update).setOnClickListener(this)
        }
        override fun onClick(v:View){
            val position = adapterPosition
            if(v.findViewById<Button>(v.id).text=="delete"){
                contentsList.removeAt(position)
                notifyItemRemoved(position)
            }else if(v.findViewById<Button>(v.id).text=="update"){
                val newdata:User = click(position)!!
                    contentsList.removeAt(position)
                    contentsList.add(position, newdata)
                notifyItemRemoved(position)
                notifyItemInserted(position)

            }

        }

    }

}