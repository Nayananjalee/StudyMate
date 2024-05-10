package com.example.studymate

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TodolistDatabaseHelper(context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {

    companion object{
        private const val DATABASE_NAME = "todo.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "todolist"
        private const val COLUMN_ID = "id"
        private const val COLUMN_TODO = "todo"
        private const val COLUMN_DATE = "date"
        private const val COLUMN_STATUS = "status"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_TODO TEXT,$COLUMN_DATE TEXT,$COLUMN_STATUS TEXT)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTableQuery)
        onCreate(db)
    }
    fun insertToDo(todolist: Todolist){
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_TODO,  todolist.todo )
            put(COLUMN_DATE,  todolist.date )
            put(COLUMN_STATUS,  todolist.status )
        }
        db.insert(TABLE_NAME,null,values)
        db.close()

    }
    @SuppressLint("Range")
    fun getAllTodos(): List<Todolist> {
        val todoList = mutableListOf<Todolist>()
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val db = readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
                val todo = cursor.getString(cursor.getColumnIndex(COLUMN_TODO))
                val date = cursor.getString(cursor.getColumnIndex(COLUMN_DATE))
                val status = cursor.getString(cursor.getColumnIndex(COLUMN_STATUS))
                todoList.add(Todolist(id, todo, date, status))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return todoList
    }




}