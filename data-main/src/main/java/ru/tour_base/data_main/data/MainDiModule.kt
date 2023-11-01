package ru.tour_base.data_main.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.tour_base.data_main.network.MainApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainDiModule {

    @Singleton
    @Provides
    fun provideMainApiService(retrofit: Retrofit) = retrofit.create(MainApiService::class.java)

    //TODO: add repository here when it is created
}