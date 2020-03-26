package com.fashi.githubtrend.adapter

import android.content.Context
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fashi.githubtrend.R
import com.fashi.githubtrend.model.Repository

open class RepositoryAdapter(
    private val context: Context,
    private val repositories: ArrayList<Repository>
    ) :
    RecyclerView.Adapter<RepositoryAdapter.CustomViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item, parent, false)

        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val repository = repositories[position]
        holder.repoName.text = repository.getName()
        holder.repoAuthorName.text = repository.getAuthorName()
        holder.repoStar.text = repository.getStars().toString()
    }

    override fun getItemCount(): Int {
        return repositories.size
    }

    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var repoName: TextView
        var repoAuthorName: TextView
        var repoStar: TextView

        init {
            repoName = view.findViewById(R.id.repoName)
            repoAuthorName = view.findViewById(R.id.repoAuthName)
            repoStar = view.findViewById(R.id.repStar)

        }

    }
}
