package com.example.studymate.database

import androidx.lifecycle.LiveData

class TaskRepository(private val todoDao: TodoDao) {
    val getTodosOrderdByDate: LiveData<List<Todo>> = todoDao.getTodosOrderdByDate()

     suspend fun insertTodo(todo:Todo){
         todoDao.insertTodo(todo)
     }

}