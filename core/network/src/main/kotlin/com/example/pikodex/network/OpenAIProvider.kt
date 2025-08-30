package com.example.pikodex.network

/**
 * Stub implementation that would call OpenAI APIs.
 */
class OpenAIProvider : AiProvider {
    override suspend fun identifyAnimal(imageBytes: ByteArray): Result<AnimalInfo> {
        return Result.Error(UnsupportedOperationException("OpenAI integration not implemented"))
    }
}
