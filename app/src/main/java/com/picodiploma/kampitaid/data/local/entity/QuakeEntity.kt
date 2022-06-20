package com.picodiploma.kampitaid.data.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "quake_table")
@Parcelize
data class QuakeEntity(

    @PrimaryKey(autoGenerate = true)
    @field:ColumnInfo(name = "id")
    var id: Int = 0,

    @field:ColumnInfo(name = "lat")
    var latitude: Double?,

    @field:ColumnInfo(name = "lon")
    var longitude: Double?,

    @field:ColumnInfo(name = "radius")
    var radius: Double? = 0.0,

    @field:ColumnInfo(name = "published_at")
    var publishedAt: String?,
): Parcelable