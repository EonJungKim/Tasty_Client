package kr.co.eonjung.common.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kr.co.eonjung.common.db.entity.Region

@Dao
interface RegionDao {

    @Query("SELECT * FROM region WHERE LENGTH(code) = 2 ORDER BY idx")
    fun getSidoList(): List<Region>

    @Query("SELECT * FROM region WHERE LENGTH(code) = 4 AND code LIKE ':cdSido__'")
    fun getSggList(cdSido: String): List<Region>

    @Query("SELECT * FROM region WHERE LENGTH(code) = 6 AND code LIKE ':cdSgg__'")
    fun getUmdList(cdSgg: String): List<Region>

    @Insert
    fun insRegion(regions: List<Region>)

    @Query("SELECT COUNT(*) FROM region")
    fun getCount(): Int
}