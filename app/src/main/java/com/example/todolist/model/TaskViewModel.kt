package com.example.todolist.model

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.data.TaskData
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class TaskViewModel : ViewModel() {

     val title = MutableLiveData<String>()
     val description = MutableLiveData<String>()
     val finalDay = MutableLiveData<String>()

//    @RequiresApi(Build.VERSION_CODES.O)
//var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
//
//@RequiresApi(Build.VERSION_CODES.O)
//var TaskDday = LocalDate.parse("12-04-2022", formatter)
//
//@RequiresApi(Build.VERSION_CODES.O)
//var creationDate = LocalDate.parse("15-11-2022", formatter)


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
        task.addTask(TaskInfo(title.value.toString(),finalDay.value.toString(),false, description.value.toString(), "Today"))
      //  Log.d("Zamel", "add: ${x.toString()}")
    }

}