package com.example.virginmoneychallenge

import com.example.virginmoneychallenge.data.ChallengeRepo
import com.example.virginmoneychallenge.data.ChallengeRepoImpl
import com.example.virginmoneychallenge.data.remote.APIService
import com.example.virginmoneychallenge.data.remote.dtos.people.PeopleDTO
import com.example.virginmoneychallenge.data.remote.dtos.room.RoomDTO
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ChallengeRepoTest {

    @Mock
    private lateinit var apiService: APIService

    private lateinit var repo: ChallengeRepo

    @Before
    fun setUp() {
        repo = ChallengeRepoImpl(apiService)
    }

    @Test
    fun `test getPeople returns correct data`() = runBlocking {
        val peopleDTOs = listOf(
            PeopleDTO(firstName = "John", lastName = "Doe", avatar = "avatar",
                email = "john.doe@gmail.com", jobtitle = "Software Engineer", favouriteColor = "Blue",
            createdAt = null, fromName = null, id = "0", name = null, size = null, to = null, type = null),
            PeopleDTO(firstName = "Jane", lastName = "Smith", avatar = "avatar",
                email = "jane.smith@gmail.com", jobtitle = "Data Scientist", favouriteColor = "Green",
                createdAt = null, fromName = null, id = "1", name = null, size = null, to = null, type = null)
        )

        `when`(apiService.getPeople()).thenReturn(peopleDTOs)

        val people = repo.getPeople()

        verify(apiService).getPeople()

        assertEquals(2, people.size)

        val firstPerson = people[0]
        assertEquals("John", firstPerson.firstName)
        assertEquals("Doe", firstPerson.lastName)
        assertEquals("avatar", firstPerson.avatar)
        assertEquals("john.doe@gmail.com", firstPerson.email)
        assertEquals("Software Engineer", firstPerson.jobTitle)
        assertEquals("Blue", firstPerson.favouriteColor)
    }

    @Test
    fun `test getRooms returns correct data`() = runBlocking {
        val roomDTOs = listOf(
            RoomDTO(id = "1", isOccupied = true, maxOccupancy = 2, createdAt = null),
            RoomDTO(id = "2", isOccupied = false, maxOccupancy = 3, createdAt = null)
        )

        `when`(apiService.getRooms()).thenReturn(roomDTOs)

        val rooms = repo.getRooms()

        verify(apiService).getRooms()

        assertEquals(2, rooms.size)

        val firstRoom = rooms[0]
        assertEquals("1", firstRoom.id)
        assertEquals(true, firstRoom.isOccupied)
        assertEquals(2, firstRoom.maxOccupancy)
    }
}