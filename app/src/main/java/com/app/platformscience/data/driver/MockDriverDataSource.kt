package com.app.platformscience.data.driver

import com.app.platformscience.data.entity.Driver
import javax.inject.Inject

class MockDriverDataSource @Inject constructor() : DriverDataSource {
    override suspend fun getDrivers(): List<Driver> =
        listOf(
            Driver(name = "Everardo Welch"),
            Driver(name = "Orval Mayert"),
            Driver(name = "Howard Emmerich"),
            Driver(name = "Izaiah Lowe"),
            Driver(name = "Monica Hermann"),
            Driver(name = "Ellis Wisozk"),
            Driver(name = "Noemie Murphy"),
            Driver(name = "Cleve Durgan"),
            Driver(name = "Murphy Mosciski"),
            Driver(name = "Kaiser Sose"),

            )
}