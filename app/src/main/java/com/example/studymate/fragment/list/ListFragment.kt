package com.example.studymate.fragment.list


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studymate.MainActivity2
import com.example.studymate.viewmodel.TaskViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListFragment : Fragment() {

    private lateinit var taskViewModel: TaskViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val view = inflater.inflate(com.example.studymate.R.layout.fragment_list, container, false)
        val backButton: ImageView = view.findViewById<ImageView>(com.example.studymate.R.id.imageView6)
        backButton.setOnClickListener {
            val intent = Intent(activity, MainActivity2::class.java)
            startActivity(intent)
        }

        val adapter = ListAdapter()
        val recyclerView = view.findViewById<RecyclerView>(com.example.studymate.R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        taskViewModel.getTodosOrderdByDate.observe(viewLifecycleOwner, Observer {todo ->
            adapter.setData(todo)
        })

        view.findViewById<FloatingActionButton>(com.example.studymate.R.id.floatingActionButton).setOnClickListener {
            findNavController().navigate(com.example.studymate.R.id.action_listFragment_to_addFragment)
        }
        return view
    }


}