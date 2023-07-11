package com.example.virginmoneychallenge.data.remote

import com.example.virginmoneychallenge.data.remote.dtos.people.PeopleDTO
import com.example.virginmoneychallenge.data.remote.dtos.room.RoomDTO
import retrofit2.http.GET

interface APIService {

    @GET(PEOPLE_ENDPOINT)
    suspend fun getPeople(): List<PeopleDTO>

    @GET(ROOMS_ENDPOINT)
    suspend fun getRooms(): List<RoomDTO>

    companion object {
        private const val PEOPLE_ENDPOINT = "people"
        private const val ROOMS_ENDPOINT = "rooms"
    }
}