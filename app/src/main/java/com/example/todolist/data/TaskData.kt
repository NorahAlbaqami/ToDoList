package com.example.todolist.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.todolist.model.TaskInfo
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class TaskData {
    @RequiresApi(Build.VERSION_CODES.O)
    var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    @RequiresApi(Build.VERSION_CODES.O)
    var TaskDday = LocalDate.parse("12-04-2022", formatter)

    @RequiresApi(Build.VERSION_CODES.O)
    var creationDate = LocalDate.parse("15-11-2022", formatter)

    fun LoadTask():List<TaskInfo>{
        return listOf<TaskInfo>(
            TaskInfo("Party", TaskDday,false ,"my birthday",creationDate)
        )
    }
}