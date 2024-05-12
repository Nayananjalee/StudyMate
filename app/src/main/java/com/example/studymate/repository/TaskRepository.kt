package com.example.studymate.repository

import androidx.lifecycle.LiveData
import com.example.studymate.database.TodoDao
import com.example.studymate.model.Todo

class TaskRepository(private val todoDao: TodoDao) {
    val getTodosOrderdByDate: LiveData<List<Todo>> = todoDao.getTodosOrderdByDate()

     suspend fun insertTodo(todo: Todo){
         todoDao.insertTodo(todo)
     }
    suspend fun updateTodo(todo: Todo){
        todoDao.updateTodo(todo)
    }

}