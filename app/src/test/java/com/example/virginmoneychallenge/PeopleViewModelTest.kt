package com.example.virginmoneychallenge

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.virginmoneychallenge.data.ChallengeRepo
import com.example.virginmoneychallenge.data.local.People
import com.example.virginmoneychallenge.ui.people.PeopleViewModel

import com.example.virginmoneychallenge.util.CoroutineTestRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class PeopleViewModelTest {

    @get:Rule
    val testDispatcher = CoroutineTestRule()

    // This rule helps with testing LiveData
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    // The ViewModel we're testing
    private lateinit var viewModel: PeopleViewModel

    @Mock
    private lateinit var mockRepo: ChallengeRepo

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        viewModel = PeopleViewModel(mockRepo)
    }

    @Test
    fun verifyGetCategories() = testDispatcher.dispatcher.runBlockingTest {
        val mockResponse = listOf(
            People(
                firstName = "Bob",
                lastName = "Frankford",
                avatar = "picture",
                email = "test@test.com",
                jobTitle = "ceo",
                favouriteColor = "blue"
            )
        )

        `when`(mockRepo.getPeople()).thenReturn(mockResponse)

        viewModel.getPeople()

        testDispatcher.dispatcher.scheduler.advanceUntilIdle()

        assertEquals(mockResponse, viewModel.people.value)
    }
}