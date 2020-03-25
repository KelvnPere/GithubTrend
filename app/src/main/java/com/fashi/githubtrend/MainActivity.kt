package com.fashi.githubtrend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fashi.githubtrend.adapter.RepositoryAdapter
import androidx.recyclerview.widget.RecyclerView
import android.app.ProgressDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.fashi.githubtrend.model.Repository
import com.fashi.githubtrend.model.RepositoryList
import com.fashi.githubtrend.retrofit.RetrofitClient
import com.fashi.githubtrend.retrofit.RetrofitClient2
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    private var repositorieList: ArrayList<Repository>? = null
    private var pDialog: ProgressDialog? = null
    private var recyclerView: RecyclerView? = null
    private var repositoryAdapter: RepositoryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pDialog = ProgressDialog(this@MainActivity)
        pDialog!!.setMessage("Data is loading.. Please be patient...")
        pDialog!!.isIndeterminate = false
        pDialog!!.setCancelable(false)
        pDialog!!.show()

        getApiInfo()
    }

    private fun getApiInfo() {
        val api = RetrofitClient2.getApiService2()
        val call = api.myJSON

        call.enqueue(object : Callback<RepositoryList> {
            override fun onResponse(
                call: Call<RepositoryList>,
                response: Response<RepositoryList>
            ) {
                //Dismiss Dialog
                pDialog!!.dismiss()

                if (response.isSuccessful) {

                    repositorieList = response.body()!!.getRepositories()
                    recyclerView = findViewById<RecyclerView>(R.id.recyclerView1)
                    repositoryAdapter = RepositoryAdapter(repositorieList!!)
                    val eLayoutManager = LinearLayoutManager(applicationContext)
                    recyclerView!!.layoutManager = eLayoutManager
                    recyclerView!!.itemAnimator = DefaultItemAnimator()
                    recyclerView!!.adapter = repositoryAdapter
                }
            }

            override fun onFailure(call: Call<RepositoryList>, t: Throwable) {
                pDialog!!.dismiss()
            }
        })
    }

}

