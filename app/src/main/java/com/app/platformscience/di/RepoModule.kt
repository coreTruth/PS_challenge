package com.app.platformscience.di

import com.app.platformscience.data.driver.DriverDataSource
import com.app.platformscience.data.driver.DriverRepositoryImpl
import com.app.platformscience.data.shipment.ShipmentRepositoryImpl
import com.app.platformscience.data.driver.MockDriverDataSource
import com.app.platformscience.data.shipment.MockShipmentDataSource
import com.app.platformscience.data.shipment.ShipmentDataSource
import com.app.platformscience.domain.DriverRepository
import com.app.platformscience.domain.ShipmentRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun provideDriverRepository(driverRepositoryImpl: DriverRepositoryImpl): DriverRepository

    @Binds
    abstract fun provideDriverDataSource(mockDriverDataSource: MockDriverDataSource): DriverDataSource

    @Binds
    abstract fun provideShipmentRepository(shipmentRepositoryImpl: ShipmentRepositoryImpl): ShipmentRepository

    @Binds
    abstract fun provideShipmentDataSource(mockShipmentDataSource: MockShipmentDataSource): ShipmentDataSource


}