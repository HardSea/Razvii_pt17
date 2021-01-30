package com.pmacademy.razvii_pt17

import android.widget.ImageView
import android.widget.TextView

interface PeopleItemClickListener {
    fun onItemClick(pos: Int, nameTextView: TextView?, photoImageView: ImageView?)
}