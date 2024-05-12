package com.example.studymate.fragment.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.studymate.R
import com.example.studymate.viewmodel.TaskViewModel
import com.example.studymate.model.Todo
import java.util.Calendar


class addFragment : Fragment() {
    private lateinit var taskViewModel: TaskViewModel
    private lateinit var datePicker: DatePicker

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)


        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        datePicker = view.findViewById(R.id.datePicker)
        view.findViewById<ImageView>(R.id.imageView6).setOnClickListener {
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }

        view.findViewById<Button>(R.id.button).setOnClickListener {
            insertDataToDatabase()
        }
        return view

    }

    private fun insertDataToDatabase() {

        val task = view?.findViewById<EditText>(R.id.todo)
        val text = task?.text.toString()
        val isDone = false
        val calendar = Calendar.getInstance()
        calendar.set(datePicker.year, datePicker.month, datePicker.dayOfMonth)
        val createDate = calendar.timeInMillis

        val todo = Todo(0,text,isDone,createDate)
        taskViewModel.insertTodo(todo)
        Toast.makeText(requireContext(),"Successfully added!", Toast.LENGTH_LONG).show()

        findNavController().navigate(R.id.action_addFragment_to_listFragment)

    }

}