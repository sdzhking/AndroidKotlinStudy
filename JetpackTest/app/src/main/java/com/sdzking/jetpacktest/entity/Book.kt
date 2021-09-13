package com.sdzking.jetpacktest.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Book(var name: String, var pages: Int, var author: String): Parcelable {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}