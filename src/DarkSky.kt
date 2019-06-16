import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by Anthony-Agby on 6/16/19.
 */

class DarkSky {
    fun getWeather() {
        val apiKey = PrivateConstants.DarkSkyApiKey
        val lat = PrivateConstants.latitude
        val lon = PrivateConstants.longitude

        val url = URL("https://api.forecast.io/forecast/$apiKey/$lat,$lon")

        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET"

            println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

            inputStream.bufferedReader().use {
                it.lines().forEach { line ->
                    println(line)
                }
            }
        }
    }
}
