package com.example.home_2_android_3.ui.fragments.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.home_2_android_3.R
import com.example.home_2_android_3.databinding.FragmentSecondBinding
import com.example.home_2_android_3.data.model.RecyclerModel
import com.example.home_2_android_3.ui.fragments.first.FragmentViewModel

class SecondFragment : Fragment() {

    private var binding : FragmentSecondBinding? = null
    private val viewModel by activityViewModels<FragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater , container , false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
    }

    private fun setOnClickListener(){
        binding?.btnAdd?.setOnClickListener {
            val et = binding?.etNewPerson?.text.toString()
            viewModel.setModels(name = et)
            findNavController().navigateUp()
        }
    }
}