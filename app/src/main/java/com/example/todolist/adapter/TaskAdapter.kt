package com.example.todolist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.model.TaskInfo

class TaskAdapter(val dataSet:List<TaskInfo> , val context: Context):RecyclerView.Adapter<TaskAdapter.TaskViewHolder> (){


    class TaskViewHolder(val ui: View):RecyclerView.ViewHolder(ui){

        val title : TextView =ui.findViewById(R.id.card_title)
        val isDone : CheckBox =ui.findViewById(R.id.checkBox_task_done)
        val Dday : TextView = ui.findViewById(R.id.card_d_day)
        val descriptin : TextView = ui.findViewById(R.id.card_descriptin)
        val creationD : TextView =ui.findViewById(R.id.create_date)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.task_card, parent, false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item = dataSet[position]

        holder.title.text=item.TaskTitle
        holder.Dday.text=item.TaskDday.toString()
        holder.creationD.text=item.creationDate.toString()
        holder.descriptin.text=item.TaskDescriptin

        holder.isDone.setOnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked){

                holder.descriptin.setTextColor(context.getColor(R.color.gray))
            }else{
                holder.descriptin.setTextColor(context.getColor(R.color.teal_700))
            }
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}