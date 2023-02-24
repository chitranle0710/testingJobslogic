package com.example.apptestingmvvm.screen.toBuy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.apptestingmvvm.data.entity.ToBuyResponse
import com.example.apptestingmvvm.databinding.ItemBuyBinding

class ToBuyAdapter : RecyclerView.Adapter<ToBuyAdapter.ToBuyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToBuyViewHolder {
        return ToBuyViewHolder(
            ItemBuyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ToBuyViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    inner class ToBuyViewHolder(private val binding: ItemBuyBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(toBuyResponse: ToBuyResponse) {
            binding.tvName.text = toBuyResponse.name
            binding.tvPrice.text = toBuyResponse.price.toString()
            binding.tvQuantity.text = toBuyResponse.quantity.toString()
        }
    }

    private val diffCallBack = object : DiffUtil.ItemCallback<ToBuyResponse>() {
        override fun areItemsTheSame(oldItem: ToBuyResponse, newItem: ToBuyResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ToBuyResponse, newItem: ToBuyResponse): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallBack)

}