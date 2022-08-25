package com.app.platformscience.data.driver

import com.app.platformscience.data.entity.Driver
import com.app.platformscience.domain.DriverRepository
import javax.inject.Inject

class DriverRepositoryImpl @Inject constructor(
    private val driverDataSource: DriverDataSource
) : DriverRepository {
    override suspend fun getDrivers(): List<Driver> = driverDataSource.getDrivers()
}