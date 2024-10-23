package com.example.investor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.SearchView
import android.view.inputmethod.InputMethodManager
import android.content.Context

class ProgressCheckList : AppCompatActivity() {

    private lateinit var adapter: ProgressCheckListAdapter
    private lateinit var pclList: MutableList<PCLCard>
    private lateinit var filteredList: MutableList<PCLCard>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_check_list)

        // Initialize RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        pclList = mutableListOf(
            PCLCard("ZenithWorks", "AI Transportation System", "Pending"),
            PCLCard("Bright Hatch", "Smart Home Automation", "Done"),
            PCLCard("QuantumBloom", "Stock Prediction System", "On-going"),
            PCLCard("CloudVibe", "Company Management System", "On-going")
        )

        filteredList = pclList.toMutableList()

        // Set the adapter for RecyclerView
        adapter = ProgressCheckListAdapter(filteredList)
        recyclerView.adapter = adapter

        // Search functionality
        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filter(newText)
                return true
            }
        })

        // Ensure the SearchView is expanded and focused
        searchView.isIconified = false
        searchView.requestFocus()

        // Set the placeholder text in the search bar
        searchView.queryHint = "Search progress reports"
    }

    // Function to filter the list
    private fun filter(query: String?) {
        val lowerCaseQuery = query?.lowercase()
        filteredList.clear()

        if (!lowerCaseQuery.isNullOrEmpty()) {
            val filtered = pclList.filter { it.startupName.lowercase().contains(lowerCaseQuery) }
            filteredList.addAll(filtered)
        } else {
            filteredList.addAll(pclList)
        }

        adapter.notifyDataSetChanged()
    }
}
