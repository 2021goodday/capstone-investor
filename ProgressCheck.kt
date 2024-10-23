package com.example.investor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.investor.databinding.ActivityProgressCheckBinding

class ProgressCheck : AppCompatActivity() {
    private lateinit var binding: ActivityProgressCheckBinding
    private lateinit var adapter: ProgressCheckAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgressCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = ProgressCheckAdapter(getItems())
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@ProgressCheck)
            adapter = this@ProgressCheck.adapter
        }
    }

    private fun getItems(): List<ProgressCheckItem> {
        return listOf(
            ProgressCheckItem(1, "Company Management System", "Ecommerce", "₱100,000.70", "CloudVibe", "On-going", "This is the project description.")
        )
    }
}