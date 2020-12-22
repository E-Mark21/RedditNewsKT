package com.myprog.redditnewskt.imageviewerscreen

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.myprog.redditnewskt.R
import com.squareup.picasso.Picasso

lateinit var mImageView: ImageView
const val EXTRA_URL = "url_pictures"

class ImageViewerScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_viewer)
        mImageView = findViewById(R.id.url_image)
        var url = intent.extras?.get(EXTRA_URL) as String
        Picasso.with(applicationContext).load(url)
            .placeholder(R.drawable.placeholder).into(mImageView)
    }
}