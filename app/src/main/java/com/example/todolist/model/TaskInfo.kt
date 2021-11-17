package com.example.todolist.model

import androidx.lifecycle.LiveData
import java.time.LocalDate


data class TaskInfo(
    val TaskTitle: String,
    val TaskDday: String,
    val isDone:Boolean = false,
    val TaskDescriptin:String,
                     //val creationDate : LocalDate
    val creationDate: String ="Today"
)
