package com.example.studymate.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {

    private val getTodosOrderdByDate: LiveData<List<Todo>>
    private val repository: TaskRepository

    init {
        val todoDao = TodoDatabase.getDatabase(application).todoDao()
        repository = TaskRepository(todoDao)
        getTodosOrderdByDate = repository.getTodosOrderdByDate
    }

    fun insertTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertTodo(todo)

        }
    }
}