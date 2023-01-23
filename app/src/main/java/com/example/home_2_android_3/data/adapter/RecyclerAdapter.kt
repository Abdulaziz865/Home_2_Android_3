package com.example.home_2_android_3.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.home_2_android_3.data.model.RecyclerModel
import com.example.home_2_android_3.databinding.ItemNameBinding

class RecyclerAdapter : ListAdapter<RecyclerModel, RecyclerAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemNameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(recyclerModel: RecyclerModel) {
            binding.rvTvName.text = recyclerModel.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<RecyclerModel>() {
            override fun areItemsTheSame(oldItem: RecyclerModel, newItem: RecyclerModel): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: RecyclerModel,
                newItem: RecyclerModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}