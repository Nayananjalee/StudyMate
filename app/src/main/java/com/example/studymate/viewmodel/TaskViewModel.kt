package com.example.studymate.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.studymate.repository.TaskRepository
import com.example.studymate.database.TodoDatabase
import com.example.studymate.model.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {

    val getTodosOrderdByDate: LiveData<List<Todo>>
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
    fun updateTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTodo(todo)

        }
    }
        fun deleteTodo(todo: Todo) {
            viewModelScope.launch(Dispatchers.IO) {
                repository.deleteTodo(todo)

            }
        }

}