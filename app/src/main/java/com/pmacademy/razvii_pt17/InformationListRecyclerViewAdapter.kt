package com.pmacademy.razvii_pt17

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class InformationListRecyclerViewAdapter :
    RecyclerView.Adapter<InformationListRecyclerViewAdapter.CustomViewHolder>() {

    private val informationTextList = listOf(
        "Google meet",
        "Email address",
        "Phone number",
        "Home number"
    )
    private val informationPhotoList = listOf(
        R.drawable.ic_videocam,
        R.drawable.ic_home,
        R.drawable.ic_phone,
        R.drawable.ic_home
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {

        val itemVIew =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_information_list_item, parent, false)
        return CustomViewHolder(itemVIew)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindElements(informationTextList[position], informationPhotoList[position])
    }

    override fun getItemCount(): Int {
        return informationTextList.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var tvInformation: TextView? = null
        private var ivPhoto: ImageView? = null

        fun bindElements(
            information: String,
            photoResource: Int
        ) {
            tvInformation?.text = information
            ivPhoto?.setImageResource(photoResource)

        }

        init {
            tvInformation = itemView.findViewById(R.id.tv_information)
            ivPhoto = itemView.findViewById(R.id.iv_information_photo)

        }

    }
}