package kr.co.eonjung.common.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "region")
data class Region (
        @PrimaryKey val idx: Int,
        @ColumnInfo(name = "code") val code: String,
        @ColumnInfo(name = "name") val name: String
)