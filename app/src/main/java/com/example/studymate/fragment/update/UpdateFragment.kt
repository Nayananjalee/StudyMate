package com.example.studymate.fragment.update

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.studymate.R
import com.example.studymate.TodayActivity
import com.example.studymate.model.Todo
import com.example.studymate.viewmodel.TaskViewModel
import java.util.Calendar

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var taskViewModel: TaskViewModel
    private lateinit var datePicker: DatePicker

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)



        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        datePicker = view.findViewById(R.id.datePicker)
        // Get a reference to the EditText view
        val updateTodoEditText = view.findViewById<EditText>(R.id.update_todo)
        updateTodoEditText.setText(args.currentTodo.text)
        // Set the date in the DatePicker
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = args.currentTodo.createDate
        datePicker.init(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH),
            null
        )

        view.findViewById<ImageView>(R.id.imageView6).setOnClickListener {
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }

        val updateButton = view.findViewById<Button>(R.id.button)
        updateButton.setOnClickListener{
            updateItem()

        }
        val deleteButton = view.findViewById<Button>(R.id.button2)
        deleteButton.setOnClickListener{
            taskViewModel.deleteTodo(args.currentTodo)
            Toast.makeText(requireContext(), "Delete Successfully!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        return view
    }
    private fun updateItem(){
        val task = view?.findViewById<EditText>(R.id.update_todo)?.text.toString()
        val status = view?.findViewById<CheckBox>(R.id.update_status)?.isChecked() ?: false
        val calendar = Calendar.getInstance()
        calendar.set(datePicker.year, datePicker.month, datePicker.dayOfMonth)
        val createDate = calendar.timeInMillis

        val todo = Todo(args.currentTodo.id, task, status, createDate)
        taskViewModel.updateTodo(todo)
        Toast.makeText(requireContext(), "Update Successfully!", Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_updateFragment_to_listFragment)
    }




}