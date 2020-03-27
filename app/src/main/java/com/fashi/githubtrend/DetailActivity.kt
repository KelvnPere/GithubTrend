package com.fashi.githubtrend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.fashi.githubtrend.model.Repository

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val model = intent.getParcelableExtra<Repository>(
            GithubRepositoryActivity.INTENT
        )

        val line1 = model.name
        val line2 = model.authorName
        val line3 = model.stars

        val name1 = findViewById<TextView>(R.id.name)
        val autho1 = findViewById<TextView>(R.id.author)
        val star1 = findViewById<TextView>(R.id.star)

        name1.text = line1
        autho1.text = line2
        star1.text = line3.toString()
//

    }


}
