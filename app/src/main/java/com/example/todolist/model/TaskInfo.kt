package com.example.todolist.model

import java.time.LocalDate


data class TaskInfo (val TaskTitle :String ,
                     val TaskDday: LocalDate,
                     val isDone :Boolean ,
                     val TaskDescriptin:String ,
                     val creationDate : LocalDate
)