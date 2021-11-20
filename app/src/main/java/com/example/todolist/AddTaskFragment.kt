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
import com.google.android.material.datepicker.MaterialDatePicker


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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            nora=viewModel
            addFragment = this@AddTaskFragment
        }
        var cindex = 0
        arguments?.let {
            cindex=it?.getInt("index")
        }
        binding?.addTaskButton?.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(AddTaskFragmentDirections.actionAddTaskFragmentToListOfTask(cindex))

            viewModel.add()
        }
    }
    fun showCalender() {
        val builder = MaterialDatePicker.Builder.datePicker()
        val picker = builder.build()
        picker.show(requireFragmentManager(), picker.toString())

        picker.addOnNegativeButtonClickListener {
        }
        picker.addOnPositiveButtonClickListener {
            viewModel.formatDate(it)
        }
    }
}