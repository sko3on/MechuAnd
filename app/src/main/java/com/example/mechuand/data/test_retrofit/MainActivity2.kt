package com.example.mechuand.data.test_retrofit

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.mechuand.R
import com.example.mechuand.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    lateinit var retorfitFrag: RetrofitFragment
    var mode = "retrofit"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        retorfitFrag = RetrofitFragment()

        supportFragmentManager.beginTransaction().replace(R.id.activity_content, retorfitFrag)
            .commit()
        supportActionBar?.title = "Retrofit Test"

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            supportFragmentManager.beginTransaction().replace(R.id.activity_content, retorfitFrag)
                .commit()
            mode = "retrofit"
            supportActionBar?.title = "Retrofit Test"

        return super.onOptionsItemSelected(item)
    }
}
