package com.example.investor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.investor.databinding.ActivityInvestmentPitchDetailsBinding

class InvestmentPitchDetails : AppCompatActivity() {
    private lateinit var binding: ActivityInvestmentPitchDetailsBinding
    private lateinit var adapter: InvestmentPitchDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInvestmentPitchDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = InvestmentPitchDetailsAdapter(getItems())
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@InvestmentPitchDetails)
            adapter = this@InvestmentPitchDetails.adapter
        }
    }

    private fun getItems(): List<InvestmentPitchDetailsItem> {
        return listOf(
            InvestmentPitchDetailsItem(1, "Bright Hatch", "Company Management System", "A platform designed to streamline operations by integrating employee management, payroll, project tracking, and reporting.", "www.projectlink.com", "https://bit.ly/3YiCwcN")
        )
    }
}
