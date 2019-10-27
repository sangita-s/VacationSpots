package com.practice.vacationspots

import android.graphics.Color
import com.practice.vacationspots.R
import java.util.*

data class Category(var imageID: Int, var title: String, var intColor: Int)

object Task {

    private val images = arrayListOf(
        R.drawable.reservations,
        R.drawable.saved_places,
        R.drawable.getting_around,
        R.drawable.things_to_know,
        R.drawable.things_to_do,
        R.drawable.food_drinks,
        R.drawable.day_plans
    )

    private val intColors = arrayListOf(
        Color.parseColor("#9675CE"),
        Color.parseColor("#4386F5"),
        Color.parseColor("#479050"),
        Color.parseColor("#EC8232"),
        Color.parseColor("#5AC7DB"),
        Color.parseColor("#52C3FA"),
        Color.parseColor("#F5B432")
    )

    private val titles = arrayListOf(
        "Reservations",
        "Saved Places",
        "Getting Around",
        "Things to Know",
        "Things to Do",
        "Food and Drinks",
        "Day Plans"
    )

    var list: ArrayList<Category>? = null
        get() {

            if (field != null)
                return field

            field = ArrayList()
            for (i in images.indices) {

                val imageId = images[i]
                val title = titles[i]
                val colorValue = intColors[i]
                val category = Category(
                    imageId,
                    title,
                    colorValue
                )
                field!!.add(category)
            }

            return field
        }
}
