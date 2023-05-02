package com.example.punkapi.di

import com.example.punkapi.BuildConfig
import com.example.punkapi.api.PunkApi
import com.example.punkapi.api.repo.RemoteRepository
import com.example.punkapi.api.repo.RepositoryContract
import com.example.punkapi.api.usecase.GetBeerPageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
object ApiModule {

    @Provides
    fun providePunkApi(): PunkApi {
        return PunkApi.create(BuildConfig.PUNK_API_BASE_URL)
    }

    @Provides
    fun provideRepository(api: PunkApi): RepositoryContract {
        return RemoteRepository(api)
    }


    @Provides
    fun provideGetBeerPageUseCase(repo: RepositoryContract) = GetBeerPageUseCase(repo)
}