package com.example.investor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.investor.databinding.ItemInvestmentPitchDetailsBinding

class InvestmentPitchDetailsAdapter(private val itemList: List<InvestmentPitchDetailsItem>) : RecyclerView.Adapter<InvestmentPitchDetailsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemInvestmentPitchDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount() = itemList.size

    class ViewHolder(private val binding: ItemInvestmentPitchDetailsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: InvestmentPitchDetailsItem) {
            // Bind data to the TextViews
            binding.tvStartupName1.text = item.startupName
            binding.tvProjectName1.text = item.projectName
            binding.tvAboutProject1.text = item.aboutProject
            binding.tvProjectLink1.text = item.projectLink
            binding.tvProjectPDF1.text = item.projectPDF

            // Enable JavaScript and load the Google Drive video URL in the WebView
            binding.systemTeaserWebView1.settings.javaScriptEnabled = true
            binding.systemTeaserWebView1.loadUrl("https://drive.google.com/file/d/1FrmGP0ob6xrdJUEHv71C-LzskPdaP94F/view?usp=drive_link")
        }
    }
}
