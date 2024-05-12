package com.example.studymate.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow


class TaskViewModel(private val taskDao: TaskDao) : ViewModel() {
    fun getAllTasks(): LiveData<List<Task>> {
        return taskDao.getAllTasks()
    }

    fun getTasksForDate(date: Long): LiveData<List<Task>> {
        return taskDao.getTasksForDate(date)
    }

    fun insertTask(task: Task) {
        taskDao.insertTask(task)
    }

    suspend fun updateTask(task: Task) {
        taskDao.updateTask(task)
    }

    suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }
}