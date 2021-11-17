package com.example.todolist.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter


//@RequiresApi(Build.VERSION_CODES.O)
//var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
//
//@RequiresApi(Build.VERSION_CODES.O)
//var TaskDday = LocalDate.parse("12-04-2022", formatter)
//
//@RequiresApi(Build.VERSION_CODES.O)
//var creationDate = LocalDate.parse("15-11-2022", formatter)

var Tasklist: MutableList<TaskInfo> = mutableListOf(
    TaskInfo("mamam", "99/99/9999",false ,"jjjj","fcgvhbjnkml,"),
            TaskInfo("mamam", "99/9999/9999",false ,"jjjj","fcgvhbjnkml,")
)