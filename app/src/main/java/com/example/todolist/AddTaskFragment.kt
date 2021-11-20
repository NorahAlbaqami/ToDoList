package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.todolist.databinding.FragmentAddTaskBinding
import com.example.todolist.model.TaskInfo
import com.example.todolist.model.TaskViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*


class AddTaskFragment : Fragment() {
    private val viewModel: TaskViewModel by viewModels()
    private lateinit var binding: FragmentAddTaskBinding
    var isDatePassed = false


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
            comperTime()
           if (isDatePassed){
               viewModel.add()
               Navigation.findNavController(view).navigate(AddTaskFragmentDirections.actionAddTaskFragmentToListOfTask(cindex))

           }else {
               Toast.makeText(this.requireContext(), "please enter valid date", Toast.LENGTH_SHORT).show()
           }



        }

    }


    fun showCalender() {
        val builder = MaterialDatePicker.Builder.datePicker().setTitleText("Select Date")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
        val picker = builder.build()
        picker.show(parentFragmentManager, picker.toString())

        picker.addOnNegativeButtonClickListener {
        }
        picker.addOnPositiveButtonClickListener {
            viewModel.dateInMelliSeconds.value = it
            viewModel.formatDate(it)
        }
    }



    fun comperTime(){

        if(System.currentTimeMillis() > viewModel.dateInMelliSeconds.value!!){
            isDatePassed = false
            Toast.makeText(this.requireContext(), "Time's up", Toast.LENGTH_SHORT).show()
        }else{
            isDatePassed = true
            Toast.makeText(this.requireContext(), "Still time", Toast.LENGTH_SHORT).show()
        }

    }
}