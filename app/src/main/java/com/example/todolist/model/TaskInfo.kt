package com.example.todolist.model
data class TaskInfo(
    val TaskTitle: String,
    val TaskDday: String,
    val isDone:Boolean = false,
    val TaskDescriptin:String,
    val creationDate: String,
    val dateInMelliSeconds: Long? = 0
)
