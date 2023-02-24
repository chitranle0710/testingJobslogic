package com.example.apptestingmvvm.screen.toCall

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.apptestingmvvm.data.entity.ToCallResponse
import com.example.apptestingmvvm.databinding.ItemToCallBinding

class ToCallListAdapter : RecyclerView.Adapter<ToCallListAdapter.ToCallViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToCallViewHolder {
        return ToCallViewHolder(
            ItemToCallBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ToCallViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    inner class ToCallViewHolder(private val binding: ItemToCallBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(toCallResponse: ToCallResponse) {
            binding.tvName.text = toCallResponse.name
            binding.tvNumber.text = toCallResponse.number
        }
    }

    private val diffCallBack = object : DiffUtil.ItemCallback<ToCallResponse>() {
        override fun areItemsTheSame(oldItem: ToCallResponse, newItem: ToCallResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ToCallResponse, newItem: ToCallResponse): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallBack)
}