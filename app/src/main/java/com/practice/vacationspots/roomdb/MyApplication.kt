package com.practice.vacationspots.roomdb

import android.app.Application
import android.os.AsyncTask
import com.practice.vacationspots.Destination
import com.practice.vacationspots.VacationSpots

class MyApplication: Application() {

    private var destinationDao: DestinationDao? = null

    override fun onCreate() {
        super.onCreate()

        val appDatabase = AppDatabase.initDatabase(this)
        destinationDao = appDatabase!!.destinationDao()
        insertAll(VacationSpots.list!!) // Populate database when app starts
    }

    private fun insertAll(destinations: List<Destination>) {
        InsertAsyncTask(destinationDao!!).execute(destinations)
    }

    companion object {
        private class InsertAsyncTask(private val destinationDao: DestinationDao) : AsyncTask<List<Destination>, Void, Void>() {

            override fun doInBackground(vararg params: List<Destination>): Void? {

                destinationDao.insertAll(params[0])
                return null
            }
        }
    }
}
