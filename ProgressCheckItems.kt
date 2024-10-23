package com.example.investor

data class ProgressCheckItem(
    val id: Int,
    val projectName: String,
    val category: String,
    val amount: String,
    val startupCompany: String,
    val status: String,
    val description: String
)