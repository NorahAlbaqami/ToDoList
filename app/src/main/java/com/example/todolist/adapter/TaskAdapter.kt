package com.example.todolist.adapter

import android.content.Context
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.EditTaskFragment
import com.example.todolist.EditTaskFragmentDirections
import com.example.todolist.ListOfTaskDirections
import com.example.todolist.R
import com.example.todolist.data.TaskData
import com.example.todolist.model.TaskInfo
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class TaskAdapter(val dataSet:MutableList<TaskInfo> , val context: Context):RecyclerView.Adapter<TaskAdapter.TaskViewHolder> (){
    private var MyList=TaskData()

    class TaskViewHolder(val ui: View):RecyclerView.ViewHolder(ui){

        val title : TextView =ui.findViewById(R.id.card_title)
        val isDone : CheckBox =ui.findViewById(R.id.checkBox_task_done)
        val Dday : TextView = ui.findViewById(R.id.card_d_day)
        val descriptin : TextView = ui.findViewById(R.id.card_descriptin)
        val creationD : TextView =ui.findViewById(R.id.create_date)
        val edit :Button=ui.findViewById(R.id.edit_task_button)
        val delete :Button =ui.findViewById(R.id.delete_task_button)
//        val save :Button=ui.findViewById(R.id.save)
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
        holder.edit.setOnClickListener {
         var action =ListOfTaskDirections.actionListOfTaskToEditTaskFragment(position)
         holder.edit.findNavController().navigate(action)

        }

        holder.delete.setOnClickListener {
            MaterialAlertDialogBuilder(context,position)
                .setTitle("DELETE TASK")
                .setMessage("Are you Sure to delete")
                .setCancelable(false)
                .setNegativeButton(context.getString(R.string.delete)) { _, _ ->
                    MyList.deleteTask(position)
                    notifyDataSetChanged()
                }
                .show()
        }

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}