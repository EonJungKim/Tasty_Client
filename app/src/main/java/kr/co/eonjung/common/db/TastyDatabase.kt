package kr.co.eonjung.common.db

import androidx.room.Database
import androidx.room.RoomDatabase
import kr.co.eonjung.common.db.entity.Region
import kr.co.eonjung.common.db.dao.RegionDao

@Database(entities = [Region::class], version = 1)
abstract class TastyDatabase : RoomDatabase() {
    abstract fun regionDao(): RegionDao
}