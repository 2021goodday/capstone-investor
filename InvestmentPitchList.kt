package com.example.investor

import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class InvestmentPitchList : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: InvestmentPitchListAdapter
    private lateinit var searchView: SearchView

    // List of investment pitches
    private val pitchList = listOf(
        InvestmentPitchList_Class(R.drawable.cms_logo, "Bright Hatch", "Company Management System"),
        InvestmentPitchList_Class(R.drawable.aisolutions_logo, "Tech Visionaries", "AI Solutions Project"),
        InvestmentPitchList_Class(R.drawable.blockchain_logo, "InnovateX", "Blockchain Management Platform")
    )

    // A mutable list to update the filtered data
    private var filteredPitchList = pitchList.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_investment_pitch_list)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize SearchView
        searchView = findViewById(R.id.search_view)

        // Initialize the adapter and handle button clicks
        adapter = InvestmentPitchListAdapter(filteredPitchList) { pitch ->
            // Handle "View Pitch" button click here
            Toast.makeText(this, "Viewing pitch for ${pitch.startupName}", Toast.LENGTH_SHORT).show()
        }

        // Set the adapter for RecyclerView
        recyclerView.adapter = adapter

        // Set up the SearchView listener to filter results
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText ?: "")
                return true
            }
        })
    }

    // Filter the pitch list based on the search query
    private fun filterList(query: String) {
        val lowerCaseQuery = query.lowercase()

        filteredPitchList.clear()
        filteredPitchList.addAll(
            pitchList.filter {
                it.startupName.lowercase().contains(lowerCaseQuery) ||
                        it.projectName.lowercase().contains(lowerCaseQuery)
            }
        )

        // Notify the adapter that the data has changed
        adapter.notifyDataSetChanged()
    }
}
