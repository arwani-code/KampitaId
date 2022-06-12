package com.picodiploma.kampitaid.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.picodiploma.kampitaid.data.local.entity.QuakeEntity

@Dao
interface QuakeDao {

    @Query("SELECT * FROM quake_table ORDER BY id ASC")
    fun getListQuake(): LiveData<List<QuakeEntity>>

    @Query("SELECT * FROM quake_table WHERE station LIKE :title")
    fun getSearchQuake(title: String?): LiveData<List<QuakeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuake(quake: QuakeEntity?)

    @Query("DELETE FROM quake_table")
    suspend fun deleteAllQuake()

}