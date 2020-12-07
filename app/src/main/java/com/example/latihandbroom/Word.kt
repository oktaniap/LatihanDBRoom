package com.example.latihandbroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//sebagai tabel data
@Entity(tableName="word_table")
data class Word(@PrimaryKey @ColumnInfo(name = "word") val word:String) {
}