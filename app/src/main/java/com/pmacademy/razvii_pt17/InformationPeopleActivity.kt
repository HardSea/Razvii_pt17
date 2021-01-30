package com.pmacademy.razvii_pt17

import android.os.Bundle
import android.view.animation.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class InformationPeopleActivity : AppCompatActivity() {

    private lateinit var ivBackgroundPhoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_information_item)

        setupViews()
        setupRecyclerView()

    }

    private fun setupViews() {
        ivBackgroundPhoto = findViewById(R.id.iv_photo_background)
        setupAnimation()

        val tvName = findViewById<TextView>(R.id.tv_name)
        val ivPhoto = findViewById<ImageView>(R.id.iv_photo)

        val peopleName = intent.getStringExtra(EXTRA_NAME_PEOPLE)
        val peoplePhotoResource = intent.getIntExtra(EXTRA_PHOTO_PEOPLE, 0)

        tvName.text = peopleName
        ivPhoto.setImageResource(peoplePhotoResource)

    }

    private fun setupRecyclerView() {

        val rvAdapter = InformationListRecyclerViewAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.rv_list_information)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = rvAdapter

    }

    private fun setupAnimation() {

        val fadeInOut = AlphaAnimation(0f, 1f)
        fadeInOut.interpolator = DecelerateInterpolator()
        fadeInOut.duration = 400
        fadeInOut.repeatMode = Animation.REVERSE
        ivBackgroundPhoto.animation = fadeInOut

    }

    companion object {
        private const val EXTRA_NAME_PEOPLE = "people_name"
        private const val EXTRA_PHOTO_PEOPLE = "people_photo"
    }
}