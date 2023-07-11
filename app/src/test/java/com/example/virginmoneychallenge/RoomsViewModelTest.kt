package com.example.virginmoneychallenge

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.virginmoneychallenge.data.ChallengeRepo
import com.example.virginmoneychallenge.data.local.Room
import com.example.virginmoneychallenge.ui.rooms.RoomsViewModel
import com.example.virginmoneychallenge.util.CoroutineTestRule
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class RoomsViewModelTest {

    @get:Rule
    val testDispatcher = CoroutineTestRule()

    // This rule helps with testing LiveData
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    // The ViewModel we're testing
    private lateinit var viewModel: RoomsViewModel

    @Mock
    private lateinit var mockRepo: ChallengeRepo

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        viewModel = RoomsViewModel(mockRepo)
    }

    @Test
    fun verifyGetCategories() = testDispatcher.dispatcher.runBlockingTest {
        val mockResponse = listOf(
            Room(
                id = "0",
                maxOccupancy = 35,
                isOccupied = false
            )
        )

        Mockito.`when`(mockRepo.getRooms()).thenReturn(mockResponse)

        viewModel.getRooms()

        testDispatcher.dispatcher.scheduler.advanceUntilIdle()

        TestCase.assertEquals(mockResponse, viewModel.rooms.value)
    }
}