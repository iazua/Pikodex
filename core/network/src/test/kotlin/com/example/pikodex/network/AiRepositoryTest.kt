package com.example.pikodex.network

import kotlin.test.assertTrue
import kotlin.test.fail
import kotlinx.coroutines.runBlocking
import org.junit.Test

private val sampleClassification = Classification(
    kingdom = "Animalia",
    phylum = "Chordata",
    clazz = "Mammalia",
    order = "Carnivora",
    family = "Felidae",
    genus = "Panthera",
    species = "P. leo"
)

private val sampleInfo = AnimalInfo(
    commonName = "Lion",
    scientificName = "Panthera leo",
    classification = sampleClassification,
    appearance = "Large cat",
    habitat = "Savannah",
    behavior = "Social",
    diet = "Carnivore",
    geographicDistribution = "Africa",
    conservationStatus = "Vulnerable",
    funFact = "King of the jungle",
    confidence = 0.99,
    imageAttribution = null
)

class SuccessProvider : AiProvider {
    override suspend fun identifyAnimal(imageBytes: ByteArray): Result<AnimalInfo> =
        Result.Success(sampleInfo)
}

class ErrorProvider : AiProvider {
    override suspend fun identifyAnimal(imageBytes: ByteArray): Result<AnimalInfo> =
        Result.Error(RuntimeException("network error"))
}

class AiRepositoryTest {
    @Test
    fun `repository returns success from provider`() = runBlocking {
        val repo = AiRepository(SuccessProvider())
        val result = repo.identify(byteArrayOf())
        assertTrue(result is Result.Success)
    }

    @Test
    fun `repository returns error from provider`() = runBlocking {
        val repo = AiRepository(ErrorProvider())
        val result = repo.identify(byteArrayOf())
        assertTrue(result is Result.Error)
    }
}
