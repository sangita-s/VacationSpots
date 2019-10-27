package com.practice.vacationspots

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class MyAdapter(val context: Context, var destList: ArrayList<Destination>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    val TAG = "MyAdapter"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        Log.d(TAG, "onCreateViewHolder")
        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = destList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder")
        val dest = destList[position]
        holder.setData(dest, position)
        holder.setListeners()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        var crtPos: Int = -1
        var crtdestination: Destination? = null

        fun setData(dest: Destination, pos: Int) {
            itemView.apply {
                txvPlaceName.text = dest.placeName
                imvPlace.setImageResource(dest.imageId)
            }
//            itemView.txvPlaceName.text = dest.placeName
//            itemView.imvPlace.setImageResource(dest.imageId)

            this.crtPos = pos
            this.crtdestination = dest
        }

        fun setListeners() {
            itemView.apply {
                imvDelete.setOnClickListener(this@MyViewHolder)
                imvMakeCopy.setOnClickListener(this@MyViewHolder)
                rootCardView.setOnClickListener(this@MyViewHolder)
            }
        }

        override fun onClick(v: View?) {
            when (v!!.id) {
                R.id.imvDelete -> deleteItem()
                R.id.imvMakeCopy -> addItem()
                R.id.rootCardView -> openExploreActivity()
            }
        }

        fun openExploreActivity() {
            val intent = Intent(context, ExploreActivity::class.java)
            context.startActivity(intent)
        }

        private fun addItem() {
            destList.add(crtPos, crtdestination!!)
            notifyItemInserted(crtPos)

            notifyItemRangeChanged(crtPos, destList.size)
        }

        private fun deleteItem() {
            destList.removeAt(crtPos)
            notifyItemRemoved(crtPos)

            notifyItemRangeChanged(crtPos, destList.size)
        }
    }
}