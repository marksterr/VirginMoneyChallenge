package com.example.virginmoneychallenge.data

import com.example.virginmoneychallenge.data.local.People
import com.example.virginmoneychallenge.data.remote.APIService
import javax.inject.Inject

class ChallengeRepo @Inject constructor(private val service: APIService) {

    suspend fun getPeople(): List<People> {
        val peopleDTOs = service.getPeople()
        return peopleDTOs.map {
            People(
                firstName = it.firstName!!,
                lastName = it.lastName!!
            )
        }
    }
}