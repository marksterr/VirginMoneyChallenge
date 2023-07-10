package com.example.virginmoneychallenge.data.remote.dtos.people


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PeopleDTO(
    @SerialName("avatar")
    val avatar: String?,
    @SerialName("createdAt")
    val createdAt: String?,
    @SerialName("data")
    val data: DataDTO?,
    @SerialName("email")
    val email: String?,
    @SerialName("favouriteColor")
    val favouriteColor: String?,
    @SerialName("firstName")
    val firstName: String?,
    @SerialName("fromName")
    val fromName: String?,
    @SerialName("id")
    val id: String?,
    @SerialName("jobtitle")
    val jobtitle: String?,
    @SerialName("lastName")
    val lastName: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("size")
    val size: String?,
    @SerialName("to")
    val to: String?,
    @SerialName("type")
    val type: String?
)