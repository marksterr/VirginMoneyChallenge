package com.example.virginmoneychallenge.di

import com.example.virginmoneychallenge.data.ChallengeRepo
import com.example.virginmoneychallenge.data.ChallengeRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun bindChallengeRepo(challengeRepoImpl: ChallengeRepoImpl): ChallengeRepo

}