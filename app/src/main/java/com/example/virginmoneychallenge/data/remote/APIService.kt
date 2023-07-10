package com.example.virginmoneychallenge.data.remote

import com.example.virginmoneychallenge.data.remote.dtos.people.PeopleDTO
import retrofit2.http.GET

interface APIService {

    @GET(PEOPLE_ENDPOINT)
    suspend fun getPeople(): List<PeopleDTO>

    companion object {
        private const val PEOPLE_ENDPOINT = "people"
        private const val ROOMS_ENDPOINT = "rooms"
    }
}