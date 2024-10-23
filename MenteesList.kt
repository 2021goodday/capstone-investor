package com.example.investor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.SearchView

class MenteesList : AppCompatActivity() {

    private lateinit var recyclerViewMentees: RecyclerView
    private lateinit var menteesAdapter: MenteesListAdapter
    private lateinit var menteeList: List<Mentee>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mentees_list)

        // Initialize RecyclerView
        recyclerViewMentees = findViewById(R.id.recyclerViewMentees)
        recyclerViewMentees.layoutManager = LinearLayoutManager(this)

        // Sample data (replace with real data if needed)
        menteeList = listOf(
            Mentee("ZenithWorks", "Harry Enriquez", R.drawable.mentee1),
            Mentee("Bright Hatch", "Dayton Glass", R.drawable.mentee2),
            Mentee("Quantum Bloom", "Alex Brown", R.drawable.mentee3),
            Mentee("CloudVibe", "Martha Stark", R.drawable.mentee4)
        )

        // Initialize the adapter with data and click listeners
        menteesAdapter = MenteesListAdapter(
            menteeList,
            onChatClick = { mentee ->
                // Handle chat button click
                openChatWithMentee(mentee)
            },
            onProjectClick = { mentee ->
                // Handle project button click
                openProjectDetails(mentee)
            }
        )

        // Set the adapter for the RecyclerView
        recyclerViewMentees.adapter = menteesAdapter

        // Set up the SearchView to filter results
        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterMentees(newText ?: "")
                return true
            }
        })
    }

    // Filter the mentee list based on the search query
    private fun filterMentees(query: String) {
        val filteredList = menteeList.filter { mentee ->
            mentee.startupName.contains(query, ignoreCase = true) ||
                    mentee.menteeName.contains(query, ignoreCase = true)
        }

        // Update adapter with filtered list
        menteesAdapter.updateList(filteredList)
    }

    // Method to handle opening chat with mentee
    private fun openChatWithMentee(mentee: Mentee) {
        // Handle opening chat with mentee (replace with your logic)
    }

    // Method to handle opening project details
    private fun openProjectDetails(mentee: Mentee) {
        // Handle opening project details (replace with your logic)
    }
}
