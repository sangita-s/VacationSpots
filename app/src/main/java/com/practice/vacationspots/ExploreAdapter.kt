package com.practice.vacationspots

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.grid_item.view.*


class ExploreAdapter(val context: Context, var categoryList: ArrayList<Category>) : RecyclerView.Adapter<ExploreAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(itemViewHolder: MyViewHolder, position: Int) {

        val category = categoryList[position]
        itemViewHolder.setData(category, position)
    }

    override fun getItemCount() = categoryList.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(category: Category, position: Int) {

            itemView.apply {
                txvCategoryTitle.text = category.title
                imvCategoryImage.setImageResource(category.imageID)
                rootCardView.setCardBackgroundColor(category.intColor)
            }
        }
    }
}
