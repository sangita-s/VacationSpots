package com.practice.vacationspots.roomdb

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.practice.vacationspots.Destination


@Dao
interface DestinationDao {

    @Query("SELECT * FROM destinations")
    fun getAllDestinations(): LiveData<List<Destination>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(destinations: List<Destination>)

    @Query("SELECT * FROM destinations")
    fun getAllPagedDestinations(): DataSource.Factory<Int, Destination>
}
