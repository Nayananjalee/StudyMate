package com.example.studymate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nexttodo.R
import com.example.studymate.database.Task
import com.example.studymate.database.TaskViewModel

class TaskAdapter(private val tasks: List<Task>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskNameTextView: TextView = itemView.findViewById(R.id.task_name_text_view)
        val taskCompleteCheckBox: CheckBox = itemView.findViewById(R.id.task_complete_check_box)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.taskNameTextView.text = task.taskName.toString()
        holder.taskCompleteCheckBox.isChecked = task.isComplete

        // Set click listener for task item
        holder.itemView.setOnClickListener {
            // Update task status
            task.isComplete = !task.isComplete
            // Notify the ViewModel to update the task in the database

        }
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}