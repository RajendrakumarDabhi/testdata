package com.example.study.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.study.data.InventoryItem
import com.example.study.data.Item
import com.example.study.databinding.RecyclerItemBinding

class OrderAdapter(var listItem: MutableList<InventoryItem>):RecyclerView.Adapter<OrderAdapter.OrderItemViewHolder>() {

    class OrderItemViewHolder(val binding: RecyclerItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(get : InventoryItem) {
            binding.name.text = get.itemName
            binding.txtBalanceQ.text = get.quantityInStock.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderItemViewHolder {
        val binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return OrderItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderItemViewHolder, position: Int) {
        holder.bind(listItem.get(position))
    }

    override fun getItemCount(): Int {
       return listItem.size
    }

    fun updateData(list: List<InventoryItem>){
        listItem.clear()
        listItem.addAll(list)
        notifyDataSetChanged()
    }
}