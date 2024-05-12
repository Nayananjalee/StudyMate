package com.example.studymate.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "todo_table")
data class Todo(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    val text: String,
    val isDone: Boolean,
    val createDate: Long)
