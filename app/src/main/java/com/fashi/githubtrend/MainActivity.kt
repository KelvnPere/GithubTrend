package com.fashi.githubtrend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fashi.githubtrend.adapter.RepositoryAdapter
import androidx.recyclerview.widget.RecyclerView
import android.app.ProgressDialog
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.fashi.githubtrend.model.Repository
import com.fashi.githubtrend.model.RepositoryList
import com.fashi.githubtrend.retrofit.RetrofitClient2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    companion object {
        val INTENT = "OBJECT"

    }

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
                    recyclerView!!.setHasFixedSize(true)
                    val eLayoutManager = LinearLayoutManager(applicationContext)
                      recyclerView!!.layoutManager = eLayoutManager
                    recyclerView!!.adapter = repositoryAdapter
//                    recyclerView!!.addOnItemTouchListener(
//                        RecyclerItemClickListener(this,
//                            recyclerView!!, object : RecyclerItemClickListener.ClickListener {
//                                override fun onClick(view: View, position: Int) {
//                                    //Values are passing to activity & to fragment as well
//                                    Toast.makeText(
//                                        this@MainActivity,
//                                        "Single Click on position        :$position",
//                                        Toast.LENGTH_SHORT
//                                    ).show()
//                                }
//
//                                override fun onLongClick(view: View, position: Int) {
//                                    Toast.makeText(
//                                        this@MainActivity, "Long press on position :$position",
//                                        Toast.LENGTH_LONG
//                                    ).show()
//                                }
//                            })
//                    )
                }
            }

            override fun onFailure(call: Call<RepositoryList>, t: Throwable) {
                pDialog!!.dismiss()
            }
        })
    }

}

