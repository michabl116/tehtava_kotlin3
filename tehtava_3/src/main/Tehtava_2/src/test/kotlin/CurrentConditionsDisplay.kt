class CurrentConditionsDisplay : Observer {

    private var temperature: Float = 0f
    private var humidity: Float = 0f

    override fun update(data: WeatherData) {
        temperature = data.temperature
        humidity = data.humidity
        display()
    }

    fun display() {
        println("CurrentConditionsDisplay: Current conditions: ${temperature}C degrees and ${humidity}% humidity")
    }
}
