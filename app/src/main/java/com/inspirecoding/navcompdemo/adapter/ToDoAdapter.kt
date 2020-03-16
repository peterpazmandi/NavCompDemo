package com.inspirecoding.navcompdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inspirecoding.navcompdemo.R
import com.inspirecoding.navcompdemo.model.ToDo
import com.inspirecoding.navcompdemo.utils.Prioirities
import kotlinx.android.synthetic.main.item_recyclerview.view.*

class ToDoAdapter (var listOfToDos: MutableList<ToDo>): RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ToDoViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
    )

    override fun getItemCount() = listOfToDos.size

    fun refreshList(listOfToDos: MutableList<ToDo>)
    {
        this.listOfToDos = listOfToDos

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int)
    {
        holder.bind(listOfToDos[position])
    }

    inner class ToDoViewHolder (view: View): RecyclerView.ViewHolder(view)
    {
        private val tv_title = view.et_recyclerView_title
        private val tv_description = view.et_recyclerView_description
        private val iv_priority = view.iv_recyclerView_priority

        fun bind (toDoItem: ToDo)
        {
            tv_title.text = toDoItem.title
            tv_description.text = toDoItem.description
            when (toDoItem.priority)
            {
                Prioirities.LOW -> iv_priority.setBackgroundResource(R.drawable.prio_green)
                Prioirities.MEDIUM -> iv_priority.setBackgroundResource(R.drawable.prio_orange)
                Prioirities.HIGH -> iv_priority.setBackgroundResource(R.drawable.prio_red)
            }
        }
    }
}