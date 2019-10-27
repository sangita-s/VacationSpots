package com.practice.vacationspots

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var destinationViewModel: DestinationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        destinationViewModel = ViewModelProviders.of(this).get(DestinationViewModel::class.java)

        btnLoadData.setOnClickListener {
            btnLoadData.visibility = View.GONE
            setupRecyclerView()
        }
    }

    private fun setupRecyclerView() {

        val adapter = MyAdapter(this)
        recyclerView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = layoutManager

        destinationViewModel.destinationsLiveData.observe(this,
            Observer { destinations ->
//                adapter.setDestinations(destinations!!)
                adapter.submitList(destinations)
            })
    }
}
