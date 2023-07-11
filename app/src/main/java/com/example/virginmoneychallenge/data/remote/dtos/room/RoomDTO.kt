package com.example.virginmoneychallenge.data.remote.dtos.room


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RoomDTO(
    @SerialName("createdAt")
    val createdAt: String?,
    @SerialName("id")
    val id: String?,
    @SerialName("isOccupied")
    val isOccupied: Boolean?,
    @SerialName("maxOccupancy")
    val maxOccupancy: Int?
)