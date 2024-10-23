package com.example.investor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter for RecyclerView
class InvestmentPitchListAdapter(
    private val pitchList: List<InvestmentPitchList_Class>,
    private val onButtonClick: (InvestmentPitchList_Class) -> Unit  // Callback for button click
) : RecyclerView.Adapter<InvestmentPitchListAdapter.PitchViewHolder>() {

    // ViewHolder class to hold views for each item
    class PitchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val startupImage: ImageView = itemView.findViewById(R.id.startup_image)
        val startupName: TextView = itemView.findViewById(R.id.startup_name)
        val projectName: TextView = itemView.findViewById(R.id.project_name)
        val viewButton: Button = itemView.findViewById(R.id.view_button)
    }

    // Inflate the item_investment_pitch_list.xml layout for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PitchViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_investment_pitch_list, parent, false)
        return PitchViewHolder(view)
    }

    // Bind data to the views for each item
    override fun onBindViewHolder(holder: PitchViewHolder, position: Int) {
        val pitch = pitchList[position]

        // Set image, startup name, and project name
        holder.startupImage.setImageResource(pitch.startupImage)
        holder.startupName.text = pitch.startupName
        holder.projectName.text = pitch.projectName

        // Handle View Pitch button click
        holder.viewButton.setOnClickListener {
            onButtonClick(pitch)  // Trigger callback for button click
        }
    }

    // Return the total number of items
    override fun getItemCount(): Int = pitchList.size
}
