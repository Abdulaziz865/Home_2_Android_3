package com.example.home_2_android_3.ui.fragments.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.home_2_android_3.R
import com.example.home_2_android_3.databinding.FragmentFirstBinding
import com.example.home_2_android_3.data.adapter.RecyclerAdapter

class FirstFragment : Fragment() {

    private var binding: FragmentFirstBinding? = null
    private var recyclerAdapter = RecyclerAdapter()
    private val viewModel by activityViewModels<FragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setOnClickListener()
        setUpObserve()
    }

    private fun initialize() {
        binding?.rvListOfName?.adapter = recyclerAdapter
    }

    private fun setOnClickListener() {
        binding?.btnAddNewPerson?.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }

    private fun setUpObserve() {
        viewModel.noteLiveData.observe(viewLifecycleOwner){
            recyclerAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}