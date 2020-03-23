package com.fashi.githubtrend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fashi.githubtrend.adapter.RepositoryAdapter
import androidx.recyclerview.widget.RecyclerView
import android.app.ProgressDialog
import com.fashi.githubtrend.model.Repository
import com.fashi.githubtrend.model.RepositoryList
import com.fashi.githubtrend.retrofit.Api
import com.fashi.githubtrend.retrofit.RetrofitClient
import retrofit2.Call


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)

    }

}
