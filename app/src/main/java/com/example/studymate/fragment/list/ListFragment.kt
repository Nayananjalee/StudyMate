package com.example.studymate.fragment.list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studymate.MainActivity2
import com.example.studymate.R
import com.example.studymate.model.Todo
import com.example.studymate.viewmodel.TaskViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private lateinit var taskViewModel: TaskViewModel
    private lateinit var listAdapter: ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val backButton: ImageView = view.findViewById<ImageView>(com.example.studymate.R.id.imageView6)
        backButton.setOnClickListener {
            val intent = Intent(activity, MainActivity2::class.java)
            startActivity(intent)
        }
        val addTaskFab: FloatingActionButton = view.findViewById(R.id.floatingActionButton)
        val checkBoxDone: CheckBox = view.findViewById(R.id.done)
        val checkBoxNoteDone: CheckBox = view.findViewById(R.id.not_done)

        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        listAdapter = ListAdapter()

        taskViewModel.getTodosOrderdByDate.observe(viewLifecycleOwner, Observer { todos: List<Todo> ->
            listAdapter.setData(todos)
        })

        addTaskFab.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToAddFragment()
            it.findNavController().navigate(action)
        }

        checkBoxDone.setOnCheckedChangeListener { _, isChecked ->
            listAdapter.filterTasks(isChecked, checkBoxNoteDone.isChecked)
        }

        checkBoxNoteDone.setOnCheckedChangeListener { _, isChecked ->
            listAdapter.filterTasks(checkBoxDone.isChecked, isChecked)
        }

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = listAdapter

        return view
    }
}