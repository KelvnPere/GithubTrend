package com.fashi.githubtrend.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Repository {

    @SerializedName("id")
    @Expose
    private var id: Int? = null
    @SerializedName("name")
    @Expose
    private var name: String? = null

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String) {
        this.url = url
    }

    @SerializedName("url")
    @Expose
    private var url: String? = null

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String) {
        this.description = description
    }

    @SerializedName("description")
    @Expose
    private var description: String? = null
    @SerializedName("languages_url")
    @Expose
    private var language: String? = null

    fun getStars(): Int? {
        return stars
    }

    fun setStars(stars: Int?) {
        this.stars = stars
    }

    @SerializedName("stargazers_count")
    @Expose
    private var stars: Int? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getLanguage(): String? {
        return language
    }

    fun setLanguage(language: String) {
        this.language = language
    }
}