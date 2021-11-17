package com.example.todolist.data
import com.example.todolist.model.TaskInfo
import com.example.todolist.model.Tasklist


class TaskData {


    fun LoadTask():MutableList<TaskInfo>{
        return Tasklist

    }
    fun addTask(task:TaskInfo){
        Tasklist.add(task)
    }
    fun deleteTask(index:Int){
        Tasklist.removeAt(index)



    }
}