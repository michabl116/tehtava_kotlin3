
// Tätä sääasema (WeatherStation) käyttää hallitakseen havaitsijoita.
// registerObserver() lisää uuden havaitsijan.
// removeObserver() poistaa havaitsijan.
// notifyObservers() lähettää päivityksen kaikille havaitsijoille.
interface Subject {
    fun registerObserver(o: Observer)
    fun removeObserver(o: Observer)
    fun notifyObservers()
}