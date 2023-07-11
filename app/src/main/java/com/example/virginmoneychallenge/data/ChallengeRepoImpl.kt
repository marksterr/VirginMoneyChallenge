package com.example.virginmoneychallenge.data

import com.example.virginmoneychallenge.data.local.People
import com.example.virginmoneychallenge.data.local.Room
import com.example.virginmoneychallenge.data.remote.APIService
import javax.inject.Inject

class ChallengeRepoImpl @Inject constructor(private val service: APIService) : ChallengeRepo {

    override suspend fun getPeople(): List<People> {
        val peopleDTOs = service.getPeople()
        return peopleDTOs.map {
            People(
                firstName = it.firstName!!,
                lastName = it.lastName!!,
                avatar = it.avatar!!,
                email = it.email!!,
                jobTitle = it.jobtitle!!,
                favouriteColor = it.favouriteColor!!
            )
        }
    }

    override suspend fun getRooms(): List<Room> {
        val roomDTOs = service.getRooms()
        return roomDTOs.map {
            Room(
                id = it.id!!,
                maxOccupancy = it.maxOccupancy!!,
                isOccupied = it.isOccupied!!,
            )
        }
    }
}