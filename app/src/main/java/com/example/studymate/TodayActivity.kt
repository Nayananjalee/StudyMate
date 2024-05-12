package com.example.studymate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.PopupWindow
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.nexttodo.R
import com.example.studymate.database.Task
import com.example.studymate.database.TaskDao
import com.example.studymate.database.TaskDatabase
import com.example.studymate.database.TaskViewModel

class TodayActivity : AppCompatActivity() {
    private lateinit var taskViewModel: TaskViewModel
    private lateinit var taskDao: TaskDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.today)

        // Initialize ViewModel and DAO
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        taskDao = TaskDatabase.getInstance(this).taskDao()

        // Add button click listener
        val addButton = findViewById<Button>(R.id.add_button)
        addButton.setOnClickListener {
            // Show popup window to add new task
            showAddTaskPopup()
        }

        // Read tasks from database and display in RecyclerView
        taskViewModel.getAllTasks().observe(this) { tasks ->
            // Update RecyclerView adapter with tasks
            val recyclerView = findViewById<RecyclerView>(R.id.task_list)
            recyclerView.adapter = TaskAdapter(tasks)
        }
    }

    private fun showAddTaskPopup() {
        // Create a popup window to add new task
        val popupView = layoutInflater.inflate(R.layout.add_task_popup, null)
        val popupWindow = PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true)

        // Get task details from popup window
        val taskEditText = popupView.findViewById<EditText>(R.id.task_edit_text)
        val addButton = popupView.findViewById<Button>(R.id.add_button)

        addButton.setOnClickListener {
            // Add new task to database
            val task = Task(0, taskEditText.text.toString().toLong(), System.currentTimeMillis(), false)
            taskDao.insertTask(task)
            popupWindow.dismiss()
        }

        popupWindow.showAtLocation(findViewById(R.id.today_layout), Gravity.CENTER, 0, 0)
    }
}