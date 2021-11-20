package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todolist.databinding.FragmentEditTaskBinding
import com.example.todolist.model.TaskViewModel


class EditTaskFragment : Fragment() {
    private val viewModel: TaskViewModel by viewModels()
    private lateinit var binding: FragmentEditTaskBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
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
        cindex=it.getInt("index")
        }
        viewModel.catchTask(cindex)
    }

    fun updateSave(){
        var cindex = 0
        arguments?.let {
            cindex=it.getInt("index")
        }

        viewModel.UpdateTask(cindex)
        findNavController().navigate(R.id.action_editTaskFragment_to_listOfTask)

    }

}