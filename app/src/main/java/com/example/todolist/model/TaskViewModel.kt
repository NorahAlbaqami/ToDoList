package com.example.todolist.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.data.TaskData
import java.time.LocalDate

class TaskViewModel : ViewModel() {

     val title = MutableLiveData<String>()
     val description = MutableLiveData<String>()
     val finalDay = MutableLiveData<String>()



    fun add (){
     var task:TaskData= TaskData()
        task.addTask(TaskInfo(title.value.toString(),finalDay.value.toString(),false, description.value.toString(), "Today"))
      //  Log.d("Zamel", "add: ${x.toString()}")
    }

}