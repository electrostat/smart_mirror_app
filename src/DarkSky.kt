import org.json.JSONObject
import java.net.URL

/**
 * Created by Anthony-Agby on 6/16/19.
 */

class DarkSky {
    lateinit var forecast: Forecast

    fun getWeather() {
        val apiKey = PrivateConstants.DarkSkyApiKey
        val lat = PrivateConstants.latitude
        val lon = PrivateConstants.longitude

        val url = URL("https://api.forecast.io/forecast/$apiKey/$lat,$lon")
        val jsonStr = url.readText()
        val jsonObject = JSONObject(jsonStr)

        setForecast(jsonObject)
    }

    //parse json and set forecast
    fun setForecast(forecastJson: JSONObject) {
        val currently = forecastJson.getJSONObject("currently")
        val time = currently.getInt("time")
        val summary = currently.getString("summary")
        val icon = currently.getString("icon")
        val precipIntent = currently.getDouble("precipIntensity")
        val precipProb = currently.getDouble("precipProbability")
        val temp = currently.getDouble("temperature")
        val feelsLikeTemp = currently.getDouble("apparentTemperature")
        val dewPoint = currently.getInt("dewPoint")
        val humidity = currently.getDouble("humidity")
        val windSpeed = currently.getDouble("windSpeed")
        val uv = currently.getInt("uvIndex")

        forecast = Forecast(time, summary, icon, precipIntent, precipProb, temp, feelsLikeTemp, dewPoint, humidity, windSpeed, uv)

        println("forecast : $forecast")
    }
}

class Forecast(time: Int, summary: String, icon: String, precipIntent: Double, precipProb: Double, temp: Double,
               feelsLikeTemp: Double, dewPoint: Int, humidity: Double, windSpeed: Double, uv: Int) {
    var time: Int = 0
    var summaryString: String = ""
    var iconString: String = ""
    var precipIntensity: Double = 0.0
    var precipProbability: Double = 0.0
    var temperature: Double = 0.0
    var apparentTemperature: Double = 0.0
    var dewPoint: Int = 0
    var humidity: Double = 0.0
    var windSpeed: Double = 0.0
    var uvIndex: Int = 0

    init {
        this.time = time
        this.summaryString = summary
        this.iconString = icon
        this.precipIntensity = precipIntent
        this.precipProbability = precipProb
        this.temperature = temp
        this.apparentTemperature = feelsLikeTemp
        this.dewPoint = dewPoint
        this.humidity = humidity
        this.windSpeed = windSpeed
        this.uvIndex = uv
    }
}
