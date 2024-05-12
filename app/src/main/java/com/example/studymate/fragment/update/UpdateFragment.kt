package com.example.studymate.fragment.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.studymate.R
import com.example.studymate.model.Todo
import com.example.studymate.viewmodel.TaskViewModel

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        // Get a reference to the EditText view
        val updateTodoEditText = view.findViewById<EditText>(R.id.update_todo)
        updateTodoEditText.setText(args.currentTodo.text)

        val updateButton = view.findViewById<Button>(R.id.button)
        updateButton.setOnClickListener{
            updateItem()

        }
        return view
    }
    private fun updateItem(){
        val task = view?.findViewById<EditText>(R.id.update_todo).toString()

        val todo = Todo(args.currentTodo.id,task,args.currentTodo.isDone,args.currentTodo.createDate)
        taskViewModel.updateTodo(todo)
        Toast.makeText(requireContext(),"Update Successfully!", Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_updateFragment_to_listFragment)
    }


}