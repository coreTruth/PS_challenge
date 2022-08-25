package com.app.platformscience.data.driver

import com.app.platformscience.data.entity.Driver

interface DriverDataSource {
    suspend fun getDrivers():List<Driver>
}