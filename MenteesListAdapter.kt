package com.example.investor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.investor.R

// Adapter class for MenteesList
class MenteesListAdapter(
    private var menteeList: List<Mentee>,  // Original data list
    private val onChatClick: (Mentee) -> Unit,  // Chat button click listener
    private val onProjectClick: (Mentee) -> Unit  // Project button click listener
) : RecyclerView.Adapter<MenteesListAdapter.MenteeViewHolder>() {

    // Filtered list for search functionality
    private var filteredMenteeList: MutableList<Mentee> = menteeList.toMutableList()

    // ViewHolder class for Mentee items
    class MenteeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val startupName: AppCompatButton = itemView.findViewById(R.id.startupname)
        val menteeName: AppCompatButton = itemView.findViewById(R.id.menteename)
        val menteeImage: ImageView = itemView.findViewById(R.id.menteeImage)
        val chatButton: AppCompatButton = itemView.findViewById(R.id.buttonChat)
        val projectButton: AppCompatButton = itemView.findViewById(R.id.buttonProject)
    }

    // Called to create a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenteeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mentees_list, parent, false)
        return MenteeViewHolder(view)
    }

    // Called to bind data to the ViewHolder
    override fun onBindViewHolder(holder: MenteeViewHolder, position: Int) {
        val mentee = filteredMenteeList[position]

        // Bind data to views
        holder.startupName.text = mentee.startupName
        holder.menteeName.text = mentee.menteeName
        holder.menteeImage.setImageResource(mentee.imageResId)

        // Set click listeners for Chat and Project buttons
        holder.chatButton.setOnClickListener {
            onChatClick(mentee)
        }

        holder.projectButton.setOnClickListener {
            onProjectClick(mentee)
        }
    }

    // Return the size of the filtered list
    override fun getItemCount(): Int = filteredMenteeList.size

    // Method to update the adapter with a filtered list
    fun updateList(filteredList: List<Mentee>) {
        filteredMenteeList.clear()
        filteredMenteeList.addAll(filteredList)
        notifyDataSetChanged()  // Notify adapter of the data change
    }
}

// Data class representing a Mentee
data class Mentee(
    val startupName: String,  // The startup's name
    val menteeName: String,  // The mentee's name
    val imageResId: Int  // Resource ID for the mentee's image
)
