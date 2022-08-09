package com.markvtls.moviestt.di

import com.google.gson.Gson
import com.markvtls.moviestt.data.source.remote.MoviesService
import com.markvtls.moviestt.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideGsonConverter(): Gson {
        return Gson().newBuilder().serializeNulls().create()
    }

    @Singleton
    @Provides
    fun provideGetMoviesRetrofitClient(gson: Gson): MoviesService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build()
            .create(MoviesService::class.java)
    }

}
