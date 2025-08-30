package com.example.pikodex.network

/**
 * Repository that delegates identification to the provided [AiProvider].
 */
class AiRepository(private val provider: AiProvider) {
    suspend fun identify(imageBytes: ByteArray): Result<AnimalInfo> =
        provider.identifyAnimal(imageBytes)
}
