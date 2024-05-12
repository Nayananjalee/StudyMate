package com.example.studymate.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query



@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTodo(todo: Todo): Long


    @Query("SELECT * FROM todo_table ORDER BY createDate ")
    fun getTodosOrderdByDate(): LiveData<List<Todo>>
}


