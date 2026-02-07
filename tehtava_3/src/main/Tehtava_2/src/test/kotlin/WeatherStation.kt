import javax.xml.crypto.Data
// Tämä on "Subject". Se vastaanottaa uudet mittaukset ja ilmoittaa
// kaikille rekisteröidyille havaitsijoille.
// observers‑lista sisältää kaikki näyttölaitteet.
class WeatherStation: Subject {

    private val observers = mutableListOf<Observer>()
    private var currentData: WeatherData? = null

    override fun registerObserver(o: Observer) {observers.add(o)}


    override fun removeObserver(o: Observer) {
        observers.remove(o)

    }
    override fun notifyObservers() {
        for(obs in observers) {
            currentData?.let { obs.update(it) }
        }
    }

    fun  measurementsChanged(newData: WeatherData){
        this.currentData = newData
        print("WeatherStation : Got new data -> $currentData ")
        notifyObservers()
    }

}