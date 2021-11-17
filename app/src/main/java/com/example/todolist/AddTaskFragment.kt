package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.todolist.databinding.FragmentAddTaskBinding
import com.example.todolist.model.TaskInfo
import com.example.todolist.model.TaskViewModel


class AddTaskFragment : Fragment() {
    private val viewModel: TaskViewModel by viewModels()
    private lateinit var binding: FragmentAddTaskBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAddTaskBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.nora=viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding?.saveTaskButton?.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(AddTaskFragmentDirections.actionAddTaskFragmentToListOfTask())

            viewModel.add()
        }
    }

}