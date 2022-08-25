package com.app.platformscience.domain

import com.app.platformscience.data.entity.Driver

interface DriverRepository {
    suspend fun getDrivers(): List<Driver>
}