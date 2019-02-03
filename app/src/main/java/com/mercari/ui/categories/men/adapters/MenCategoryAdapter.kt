package com.mercari.ui.categories.men.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mercari.R
import com.mercari.base.AppViewHolder
import com.mercari.base.glide.GlideApp
import com.mercari.business.MenCategory
import kotlinx.android.synthetic.main.adapter_category_list_item.*

class MenCategoryAdapter(private val list: List<MenCategory>) : RecyclerView.Adapter<AppViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        return AppViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_category_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val category = list[position]
        holder.tvName.text = category.name
        val price = "$ ${category.price}"
        holder.tvPrice.text = price
        holder.tvComment.text = category.comments.toString()
        holder.tvLikes.text = category.likes.toString()
        GlideApp.with(holder.containerView).load(category.photo).placeholder(R.drawable.icon_toolbar).into(holder.ivImg)
        holder.ivSoldOut.visibility = if (category.status == "sold_out")
            View.VISIBLE
        else View.GONE


    }

    override fun getItemCount(): Int {
        return list.size
    }
}