package com.gomaa.resturanttask.data.categories

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "categoryTable")
@JsonClass(generateAdapter = true)
data class Category(
    @PrimaryKey
    @ColumnInfo(name = "id")
    override val id: Int,
    @Json(name = "name_en")
    @ColumnInfo(name = "name_en")
    override val categoryNameEn: String,
    @Json(name = "name")
    @ColumnInfo(name = "name")
    override val categoryNameAr: String,
    @Json(name = "photo")
    @ColumnInfo(name = "photo")
    override val CategoryImageUrl: String,
    @ColumnInfo(name = "percentage")
    override val percentage: Int = 0,
):BaseCategory, Parcelable
