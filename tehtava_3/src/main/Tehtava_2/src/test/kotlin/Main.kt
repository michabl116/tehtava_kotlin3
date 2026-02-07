fun main() {

    val weatherStation = WeatherStation()

    val currentDisplay = CurrentConditionsDisplay()
    val statsDisplay = StatisticsDisplay()

    weatherStation.registerObserver(currentDisplay)
    weatherStation.registerObserver(statsDisplay)

    println("--- Simulating new measurement ---")
    weatherStation.measurementsChanged(WeatherData(25.0f, 65f, 1012f))

    println("\n--- Simulating another measurement ---")
    weatherStation.measurementsChanged(WeatherData(27.5f, 70f, 1011f))

    println("\n--- Unregistering Statistics Display ---")
    weatherStation.removeObserver(statsDisplay)

    println("\n--- Simulating a final measurement ---")
    weatherStation.measurementsChanged(WeatherData(26.0f, 90f, 1013f))
}

