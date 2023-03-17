package com.example.jetpackcomposeapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.IDN
@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0 ,
    val title:String,
    val subtitle:String,

)
