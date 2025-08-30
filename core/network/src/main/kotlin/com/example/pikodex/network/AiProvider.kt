package com.example.pikodex.network

interface AiProvider {
    suspend fun identifyAnimal(imageBytes: ByteArray): Result<AnimalInfo>
}
