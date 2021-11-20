package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todolist.databinding.FragmentAddTaskBinding
import com.example.todolist.databinding.FragmentEditTaskBinding
import com.example.todolist.model.TaskViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*


class EditTaskFragment : Fragment() {
    private val viewModel: TaskViewModel by viewModels()
    private lateinit var binding: FragmentEditTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditTaskBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            nora=viewModel
            editFragment = this@EditTaskFragment
        }
        var cindex = 0
        arguments?.let {
            cindex=it?.getInt("index")
        }
        viewModel.catchTask(cindex)
        comperTime()
    }

    fun updateSave(){
        var cindex = 0
        arguments?.let {
            cindex=it?.getInt("index")
        }

        viewModel.UpdateTask(cindex)
        findNavController().navigate(R.id.action_editTaskFragment_to_listOfTask)

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
    fun comperTime(){
        var today= Date()
        val formatter = SimpleDateFormat("yyyy-MM-dd",Locale.US)
        var taskTime=formatter.parse(viewModel.finalDay.value!!)
      if(taskTime.before(today)){
            binding.editwarring.setText("Sorry we can't travel back in time for you:)")
        }
    }
}