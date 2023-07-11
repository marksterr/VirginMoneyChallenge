package com.example.virginmoneychallenge.ui.rooms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoneychallenge.data.ChallengeRepo
import com.example.virginmoneychallenge.data.local.Room
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomsViewModel @Inject constructor(private val repo: ChallengeRepo) : ViewModel() {

    private val _rooms: MutableLiveData<List<Room>> = MutableLiveData()
    val rooms: LiveData<List<Room>> get() = _rooms

    init {
        getRooms()
    }

    fun getRooms() = viewModelScope.launch {
        _rooms.value = repo.getRooms() // Update _categories value with data fetched from repository.
    }
}