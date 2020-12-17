package com.myprog.redditnewskt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.myprog.redditnewskt.newslistscreen.view.NewsListScreenView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val currentFragment =
            supportFragmentManager.findFragmentById(R.id.activity_main)
        if (currentFragment == null) {
            val fragment = NewsListScreenView.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.activity_main, fragment)
                .commit()
        }
    }
}