package com.example.pikodex.network

data class AnimalInfo(
    val commonName: String,
    val scientificName: String,
    val classification: Classification,
    val appearance: String,
    val habitat: String,
    val behavior: String,
    val diet: String,
    val geographicDistribution: String,
    val conservationStatus: String,
    val funFact: String,
    val confidence: Double,
    val imageAttribution: String?
)
