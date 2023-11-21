package com.example.moviesapp.data.model.tvShowData


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_tvShows")
data class TvShow(
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
//    @SerializedName("genre_ids")
//    val genreIds: List<Int>?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,

)