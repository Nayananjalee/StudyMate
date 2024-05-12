package com.example.studymate.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "task_name") val taskName: Long, // changed type to String
    @ColumnInfo(name = "deadline") val deadline: Long,
    @ColumnInfo(name = "is_complete") var isComplete: Boolean
)