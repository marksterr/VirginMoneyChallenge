package com.example.virginmoneychallenge.ui.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoneychallenge.data.ChallengeRepo
import com.example.virginmoneychallenge.data.local.People
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(private val repo: ChallengeRepo) : ViewModel() {

    private val _people: MutableLiveData<List<People>> = MutableLiveData()
    val people: LiveData<List<People>> get() = _people

    init {
        getPeople()
    }

    fun getPeople() = viewModelScope.launch {
        _people.value = repo.getPeople() // Update _categories value with data fetched from repository.
    }
}