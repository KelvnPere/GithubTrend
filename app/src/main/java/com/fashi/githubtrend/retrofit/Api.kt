package com.fashi.githubtrend.retrofit

import com.fashi.githubtrend.model.RepositoryList
import retrofit2.Call
import retrofit2.http.GET


 interface Api {
    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of EmployeeList
    */

    // Retrofit Get Annotation
    @get:GET("/search/repositories?q=android+language:java+language:kotlin&sort=stars&order=desc")
    val myJSON: Call<RepositoryList>
    // the method will return the list of Repository
}