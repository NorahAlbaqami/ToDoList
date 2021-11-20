package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.adapter.TaskAdapter
import com.example.todolist.data.TaskData
import com.example.todolist.databinding.FragmentListOfTaskBinding
import com.example.todolist.model.TaskViewModel

class ListOfTask : Fragment() {
    private val viewModel: TaskViewModel by viewModels()
    private var binding: FragmentListOfTaskBinding? = null
    private lateinit var recyclerView: RecyclerView
    private var dataSet =TaskData().LoadTask()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListOfTaskBinding.inflate(inflater, container, false)
        binding!!.lifecycleOwner = viewLifecycleOwner
        val view = binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding?.recyclerView!!
        binding?.recyclerView?.adapter= TaskAdapter(dataSet,requireContext())
        binding?.addTaskButton?.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(ListOfTaskDirections.actionListOfTaskToAddTaskFragment())
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}