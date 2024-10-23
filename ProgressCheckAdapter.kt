package com.example.investor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.investor.databinding.ItemProgressCheckBinding

class ProgressCheckAdapter(private val itemList: List<ProgressCheckItem>) : RecyclerView.Adapter<ProgressCheckAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProgressCheckBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount() = itemList.size

    class ViewHolder(private val binding: ItemProgressCheckBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProgressCheckItem) {
            binding.tvProjectName1.text = item.projectName
            binding.tvCategory1.text = item.category
            binding.tvAmount.text = item.amount
            binding.tvStartupCompany.text = item.startupCompany
            binding.tvStatus.text = item.status
            binding.tvDescription.text = item.description
        }
    }
}