package com.example.studymate.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "todo_table")
data class Todo(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    val text: String,
    val isDone: Boolean,
    val createDate: Long
):Parcelable
