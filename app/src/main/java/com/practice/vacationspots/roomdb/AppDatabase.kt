package com.practice.vacationspots.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.practice.vacationspots.Destination


@Database(entities = [Destination::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun destinationDao(): DestinationDao

    companion object {

        private var appDatabase: AppDatabase? = null

        fun initDatabase(context: Context): AppDatabase? {

            if (appDatabase == null) {
                synchronized(AppDatabase::class.java) {
                    if (appDatabase == null) {
                        appDatabase = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            "app_database").build()
                    }
                }
            }
            return appDatabase
        }

        fun getDatabase(context: Context): AppDatabase? = appDatabase
            ?: initDatabase(context)
    }
}
