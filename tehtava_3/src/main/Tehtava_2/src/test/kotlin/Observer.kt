// Kaikkien näyttöjen (display) täytyy toteuttaa tämä rajapinta.
// update() kutsutaan aina, kun sääasema lähettää uudet mittaukset.

interface Observer {
    fun update(data: WeatherData)
}

