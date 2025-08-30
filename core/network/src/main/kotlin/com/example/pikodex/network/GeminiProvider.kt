package com.example.pikodex.network

/**
 * Stub implementation that would call Gemini APIs.
 */
class GeminiProvider : AiProvider {
    override suspend fun identifyAnimal(imageBytes: ByteArray): Result<AnimalInfo> {
        return Result.Error(UnsupportedOperationException("Gemini integration not implemented"))
    }
}
