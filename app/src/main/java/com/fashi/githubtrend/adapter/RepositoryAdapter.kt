package com.fashi.githubtrend.adapter

import android.content.Context
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.fashi.githubtrend.R
import com.fashi.githubtrend.model.Repository

open class RepositoryAdapter(
    private val repositories: List<Repository>
//     val listener : (Repository) ->Unit
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

//        fun bind(repository: Repository, listener: (Repository) -> Unit){
//            itemView.setOnClickListener { listener(repository) }
//        }

        init {
            repoName = view.findViewById(R.id.repositoryName)
            repoAuthorName = view.findViewById(R.id.repoAuthorName)
            repoStar = view.findViewById(R.id.repoStar)
        }

    }
}
