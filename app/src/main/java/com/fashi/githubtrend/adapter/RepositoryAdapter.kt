package com.fashi.githubtrend.adapter


import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fashi.githubtrend.R
import com.fashi.githubtrend.model.Repository


class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item, parent, false)

        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val repository = repositories[position]
        holder.repoName.text = repository.getName()
        holder.repoDescribtion.text = repository.getDescription()
        holder.repoStar.text = repository.getStars().toString()
    }

    override fun getItemCount(): Int {
        return repositories.size
    }

    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var repoName: TextView
        var repoDescribtion: TextView
        var repoStar: TextView


        init {
            repoName = view.findViewById(R.id.repositoryName)
            repoDescribtion = view.findViewById(R.id.repoDescription)
            repoStar = view.findViewById(R.id.repoStar)
        }
    }
}