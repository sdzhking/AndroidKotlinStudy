package com.sdzking.jetpacktest.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class User (var firstName: String, var lastName: String, var age: Int) : Serializable{

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}