package com.practice.vacationspots

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

//class MyAdapter(val context: Context): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
class MyAdapter(val context: Context) :
    PagedListAdapter<Destination, MyAdapter.MyViewHolder>(DestinationDiffCallBack()) {

//    var destinationList = listOf<Destination>()

//    fun setDestinations(destinationList: List<Destination>) {
//        this.destinationList = destinationList
//        notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

//    override fun getItemCount(): Int = destinationList.size

    override fun onBindViewHolder(itemViewHolder: MyViewHolder, position: Int) {

//        val destination = destinationList[position]
        val destination = getItem(position)
        itemViewHolder.setData(destination!!, position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentPosition: Int = -1
        var destination: Destination? = null

        fun setData(destination: Destination, position: Int) {
            itemView.apply {
                txvPlaceName.text = destination.placeName
                imvPlace.setImageResource(destination.imageId)
            }

            this.currentPosition = position
            this.destination = destination
        }
    }

    class DestinationDiffCallBack : DiffUtil.ItemCallback<Destination>() {
        override fun areItemsTheSame(oldItem: Destination, newItem: Destination): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Destination, newItem: Destination): Boolean {
            return oldItem == newItem
        }

    }
}
