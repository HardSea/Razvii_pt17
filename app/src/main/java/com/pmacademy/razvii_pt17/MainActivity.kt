package com.pmacademy.razvii_pt17

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pmacademy.razvii_pt17.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), PeopleItemClickListener {

    private lateinit var binding: ActivityMainBinding

    private val listImage = listOf(
        R.drawable.ic_people_1,
        R.drawable.ic_people_2,
        R.drawable.ic_people_3,
        R.drawable.ic_people_4,
        R.drawable.ic_people_5,
        R.drawable.ic_people_6,
        R.drawable.ic_people_7,
        R.drawable.ic_people_8,
        R.drawable.ic_people_9,
        R.drawable.ic_people_10,
        R.drawable.ic_people_11,
        R.drawable.ic_people_12,
        R.drawable.ic_people_13,
        R.drawable.ic_people_14,
        R.drawable.ic_people_15,
        R.drawable.ic_people_16,
        R.drawable.ic_people_17,
        R.drawable.ic_people_18,
        R.drawable.ic_people_19,
        R.drawable.ic_people_20
    )

    private val listNames = listOf(
        "Sheryll Hartung",
        "Jule Bun",
        "Lorenzo Bamber",
        "Darren Kanode",
        "Cheryle Goodspeed",
        "Kraig Lagace",
        "Robena Stimac",
        "Mackenzie Luczynski",
        "Efren Chicoine",
        "Kimi Owenby",
        "Theodore Whitis",
        "Julianne Camacho",
        "Shondra Tynes",
        "Alia Levitsky",
        "Cleveland Kita",
        "Roy Sasse",
        "Alice Feaster",
        "Lisha Tibbs",
        "Kristal Tindal",
        "Roselia Cooks"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val rvAdapter = PeopleListRecyclerViewAdapter(listNames, listImage, this)
        val recyclerView = findViewById<RecyclerView>(R.id.rv_main_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = rvAdapter
    }

    override fun onItemClick(pos: Int, nameTextView: TextView?, photoImageView: ImageView?) {

        val intent = Intent(this, InformationPeopleActivity::class.java)
        intent.putExtra(EXTRA_NAME_PEOPLE, listNames[pos])
        intent.putExtra(EXTRA_PHOTO_PEOPLE, listImage[pos])

        val pairName = Pair<View, String>(
            nameTextView,
            "transition_name"
        )

        val pairPhoto = Pair<View, String>(
            photoImageView,
            "transition_photo"
        )

        val activityOptions = ActivityOptionsCompat
            .makeSceneTransitionAnimation(this, pairName, pairPhoto)

        startActivity(intent, activityOptions.toBundle())
    }

    companion object {
        private const val EXTRA_NAME_PEOPLE = "people_name"
        private const val EXTRA_PHOTO_PEOPLE = "people_photo"
    }
}
