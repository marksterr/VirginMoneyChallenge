package com.example.virginmoneychallenge.data

import com.example.virginmoneychallenge.data.local.People
import com.example.virginmoneychallenge.data.local.Room

interface ChallengeRepo {
    suspend fun getPeople(): List<People>
    suspend fun getRooms(): List<Room>
}