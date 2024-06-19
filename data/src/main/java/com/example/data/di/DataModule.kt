package com.example.data.di

import com.example.data.repository.DashboardRepository
import com.example.data.repository.DashboardRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {
    @Binds
    fun bindsDashboardRepository(dashboardRepositoryImpl: DashboardRepositoryImpl): DashboardRepository
}