package com.fashi.githubtrend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fashi.githubtrend.adapter.ReposAdapter
import androidx.recyclerview.widget.RecyclerView
import android.app.ProgressDialog
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.fashi.githubtrend.model.Repository
import com.fashi.githubtrend.model.RepositoryList
import com.fashi.githubtrend.retrofit.RetrofitClient2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList


class GithubRepositoryActivity : AppCompatActivity(), ReposAdapter.onNoteListener {

    // Pass the selected item to the activity

    companion object {
        val INTENT = "OBJECT"

    }

    private var repositorieList: ArrayList<Repository>? = null
    private var pDialog: ProgressDialog? = null
    private var recyclerView: RecyclerView? = null
    private var repositoryAdapter: ReposAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        pDialog = ProgressDialog(this@GithubRepositoryActivity)
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
                    recyclerView!!.setHasFixedSize(true)
                    val eLayoutManager = LinearLayoutManager(applicationContext)
                    recyclerView!!.layoutManager = eLayoutManager
                    repositoryAdapter = repositorieList?.let { ReposAdapter(it, this@GithubRepositoryActivity) }
                    recyclerView!!.adapter = repositoryAdapter
                }
            }

            override fun onFailure(call: Call<RepositoryList>, t: Throwable) {
                pDialog!!.dismiss()
            }
        })

    }

    override fun onNoteClick(position: Int) {
        //Toast.makeText(this, "Position$position", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, DetailActivity::class.java)
         intent.putExtra(INTENT, repositorieList!![position])
        startActivity(intent)
    }


    }


