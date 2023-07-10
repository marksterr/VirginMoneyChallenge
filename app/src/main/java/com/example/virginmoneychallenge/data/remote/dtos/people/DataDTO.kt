package com.example.virginmoneychallenge.data.remote.dtos.people


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataDTO(
    @SerialName("body")
    val body: String?,
    @SerialName("fromId")
    val fromId: String?,
    @SerialName("id")
    val id: String?,
    @SerialName("meetingid")
    val meetingid: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("toId")
    val toId: String?
)