package com.example.myapplication.data

data class TvShowResponse(
    val tv_shows: List<TvShow>
)

data class TvShow(
    val id: Int,
    val name: String,
    val permalink: String,
    val image_thumbnail_path: String,
    val network: String,
    val status: String
)

data class TvShowDetailResponse(val tvShow: TvShowDetail)


// Dans data/Models.kt


data class TvShowDetail(
    val id: Int,
    val name: String,
    val description: String,
    val image_path: String,
    val rating: String, // Demandé par le sujet
    val genres: List<String>,
    val episodes: List<Episode> // <-- AJOUT IMPORTANT
)

data class Episode(
    val season: Int,
    val episode: Int,
    val name: String,
    val air_date: String?
)