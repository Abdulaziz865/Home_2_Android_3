package com.example.home_2_android_3.ui.fragments.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.home_2_android_3.data.model.RecyclerModel

class FragmentViewModel : ViewModel() {

    private val _noteLiveData = MutableLiveData<List<RecyclerModel>>()
    val noteLiveData : LiveData<List<RecyclerModel>> = _noteLiveData

    private var noteList = mutableListOf<RecyclerModel>()

    fun setModels(name : String){
        noteList.add(RecyclerModel(name = name))
        _noteLiveData.value = noteList.toList()
    }
}