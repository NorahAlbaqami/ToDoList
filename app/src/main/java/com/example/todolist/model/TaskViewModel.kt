package com.example.todolist.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.data.TaskData
import java.text.SimpleDateFormat
import java.util.*

class TaskViewModel : ViewModel() {

     val title = MutableLiveData<String>()
     val description = MutableLiveData<String>()
     val finalDay = MutableLiveData<String>()
     val creationDay = MutableLiveData<String>()


    //fun to catch the task
    fun catchTask(index: Int){
        var item = Tasklist.get(index)
        title.value = item.TaskTitle
        description.value = item.TaskDescriptin
        finalDay.value=item.TaskDday

    }
    fun UpdateTask(index: Int){
        Tasklist.set(index,
            TaskInfo(title.value.toString(),finalDay.value.toString(),false, description.value.toString(), "Today"))

    }



    fun add (){
     var task:TaskData= TaskData()
        task.addTask(TaskInfo(
            title.value.toString(),
            finalDay.value.toString(),false,
            description.value.toString(),
            "Today"))
    }

    fun formatDate(date: Long) {
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val selectedDate = date
        finalDay.value = formatter.format(selectedDate).toString()
        val calendar = Calendar.getInstance()
        creationDay.value = formatter.format(calendar.time)
    }

}