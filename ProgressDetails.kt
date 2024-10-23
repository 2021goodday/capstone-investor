package com.example.investor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.investor.databinding.ActivityProgressDetailsBinding

class ProgressDetails : AppCompatActivity() {

    // Declare a binding object
    private lateinit var binding: ActivityProgressDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProgressDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ProgressReportDate.text = "October 23, 2024"
        binding.tvAmountValue.text = "₱250,000.00"
        binding.tvStartDateValue.text = "Aug 29, 2024"
        binding.tvTargetDateValue.text = "Nov 21, 2024"


    }
}
