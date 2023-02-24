package com.example.apptestingmvvm.screen.toSell

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.apptestingmvvm.data.entity.ItemSell
import com.example.apptestingmvvm.databinding.ItemBuyBinding

class ToSellAdapter : RecyclerView.Adapter<ToSellAdapter.ToSellViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToSellViewHolder {
        return ToSellViewHolder(
            ItemBuyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ToSellViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    inner class ToSellViewHolder(private val binding: ItemBuyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemSell: ItemSell) {
            binding.tvName.text = itemSell.name
            binding.tvPrice.text = itemSell.price.toString()
            binding.tvQuantity.text = itemSell.quantity.toString()
        }
    }

    private val diffCallBack = object : DiffUtil.ItemCallback<ItemSell>() {
        override fun areItemsTheSame(oldItem: ItemSell, newItem: ItemSell): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: ItemSell, newItem: ItemSell): Boolean {
            return oldItem.equals(newItem)
        }
    }

    val differ = AsyncListDiffer(this, diffCallBack)
}