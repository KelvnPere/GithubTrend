package com.fashi.githubtrend.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class RepositoryList {

    @SerializedName("items")
    @Expose
    private var repositories: ArrayList<Repository>? = null

    fun getRepositories(): ArrayList<Repository>? {
        return repositories
    }

    fun setRepositories(repositories: ArrayList<Repository>) {
        this.repositories = repositories
    }
}