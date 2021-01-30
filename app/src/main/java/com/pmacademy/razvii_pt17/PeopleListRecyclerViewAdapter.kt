package com.pmacademy.razvii_pt17

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PeopleListRecyclerViewAdapter(
    private val nameList: List<String>,
    private val photoList: List<Int>,
    private val peopleClickListener: PeopleItemClickListener
) : RecyclerView.Adapter<PeopleListRecyclerViewAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val itemVIew =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_people_list_item, parent, false)
        return CustomViewHolder(itemVIew)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindElements(nameList[position], photoList[position], peopleClickListener)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var tvName: TextView? = null
        private var ivPhoto: ImageView? = null

        fun bindElements(
            name: String,
            photoResource: Int,
            peopleClickListener: PeopleItemClickListener
        ) {

            val spannableText = SpannableStringBuilder(name)
            val endIndexName = spannableText.indexOf(" ")
            val boldSpan = StyleSpan(Typeface.BOLD)
            val flag = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            spannableText.setSpan(boldSpan, 0, endIndexName, flag)
            tvName?.text = spannableText

            ivPhoto?.setImageResource(photoResource)

            itemView.setOnClickListener {
                peopleClickListener.onItemClick(adapterPosition, tvName, ivPhoto)
            }
        }

        init {
            tvName = itemView.findViewById(R.id.tv_name)
            ivPhoto = itemView.findViewById(R.id.iv_photo)

        }
    }
}