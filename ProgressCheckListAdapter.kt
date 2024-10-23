package com.example.investor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProgressCheckListAdapter(private val pclList: List<PCLCard>) :
    RecyclerView.Adapter<ProgressCheckListAdapter.PCLViewHolder>() {

    class PCLViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val startupName: TextView = itemView.findViewById(R.id.startupName)
        val projectName: TextView = itemView.findViewById(R.id.projectName)
        val progressStatus: TextView = itemView.findViewById(R.id.progressStatus)
        val statusIcon: ImageView = itemView.findViewById(R.id.statusIcon)
        val viewProgressReportButton: TextView = itemView.findViewById(R.id.viewProgressReportButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PCLViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_progress_check_list, parent, false)
        return PCLViewHolder(view)
    }

    override fun onBindViewHolder(holder: PCLViewHolder, position: Int) {
        val pclCard = pclList[position]
        holder.startupName.text = pclCard.startupName
        holder.projectName.text = pclCard.projectName
        holder.progressStatus.text = pclCard.progressStatus

        when (pclCard.progressStatus) {
            "Pending" -> holder.statusIcon.setImageResource(R.drawable.status_pending)
            "Done" -> holder.statusIcon.setImageResource(R.drawable.status_done)
            "On-going" -> holder.statusIcon.setImageResource(R.drawable.status_ongoing)
            else -> holder.statusIcon.setImageResource(R.drawable.status_default)
        }
    }

    override fun getItemCount() = pclList.size
}
