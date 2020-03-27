package com.fashi.githubtrend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        githubRepository.setOnClickListener {
            val intent = Intent(this, GithubRepositoryActivity::class.java)
            startActivity(intent)
        }


    }



}
