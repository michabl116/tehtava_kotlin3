
// Tämä näyttö laskee keskilämpötilan kaikista mittauksista.
// Jokainen uusi mittaus lisätään listaan ja keskiarvo lasketaan.
class StatisticsDisplay : Observer {

    private val temperatures = mutableListOf<Float>()

    override fun update(data: WeatherData) {
        temperatures.add(data.temperature)
        display()
    }

    fun display() {
        val avg = temperatures.sum() / temperatures.size
        println("StatisticsDisplay: Avg temperature: ${avg}C")
    }
}
