/**
 * Created by Anthony-Agby on 6/9/19.
 */
package SmartMirror

import javafx.geometry.Pos
import javafx.scene.layout.BackgroundRepeat
import javafx.scene.paint.Color
import javafx.scene.text.Font
import tornadofx.*
import DarkSky
import javafx.scene.text.Text

class MirrorView : View() {
    override val root = vbox {
        style {
            backgroundColor = multi(Color.BLACK)
            backgroundRepeat = multi(BackgroundRepeat.NO_REPEAT
                    to BackgroundRepeat.NO_REPEAT)
            textFill = Color.WHITE
        }

        val darkSky = DarkSky()
        var summary = Text()
        var temperature = Text()
        var feelsLike = Text()
        var precipProbability = Text()
        var humidity = Text()
        var windSpeed = Text()
        var uvIndex = Text()

        fun updateForecast() {
            println("forecast UI updating")
            val forecast = darkSky.getForecast()
            val rainChance = forecast.precipProbability * 100
            val humidityPercent = forecast.humidity * 100

            summary.text = forecast.summaryString
            temperature.text = "Current Temp: " + forecast.temperature.toString() + "°F"
            feelsLike.text = "Feels like " + forecast.apparentTemperature.toString() + "°F"
            precipProbability.text = rainChance.toString() + "% chance of rain"
            humidity.text = humidityPercent.toString() + "% humidity"
            windSpeed.text = forecast.windSpeed.toString() + "mph winds"
            uvIndex.text = "UV Index: " + forecast.uvIndex.toString()
        }

        prefWidth = 600.0
        prefHeight = 600.0

        spacing = 20.0
        padding = insets(20, 20)

        text("Date") {
            font = Font.font(30.0)
            alignment = Pos.CENTER
            fill = Color.WHITE
        }

        text("Clock") {
            font = Font.font(30.0)
            alignment = Pos.CENTER
            fill = Color.WHITE
        }

        vbox {
            summary = text("Summary") {
                font = Font.font(30.0)
                alignment = Pos.CENTER
                fill = Color.WHITE

            }

            temperature = text("temperature") {
                font = Font.font(30.0)
                alignment = Pos.CENTER
                fill = Color.WHITE
            }

            feelsLike = text("Feels Like") {
                font = Font.font(30.0)
                alignment = Pos.CENTER
                fill = Color.WHITE
            }

            precipProbability = text("Precipitation Probability") {
                font = Font.font(30.0)
                alignment = Pos.CENTER
                fill = Color.WHITE
            }

            humidity = text("humidity") {
                font = Font.font(30.0)
                alignment = Pos.CENTER
                fill = Color.WHITE
            }

            windSpeed = text("windSpeed") {
                font = Font.font(30.0)
                alignment = Pos.CENTER
                fill = Color.WHITE
            }

            uvIndex = text("uvIndex") {
                font = Font.font(30.0)
                alignment = Pos.CENTER
                fill = Color.WHITE
            }
        }

        hbox {
            button("Request") {
                font = Font.font(20.0)
                action {
                    darkSky.getWeather()
                }
            }

            button("Update View") {
                font = Font.font(20.0)
                action {
                    updateForecast()
                }
            }
        }

        sceneProperty().addListener { _, _, n ->
            n.fill = null
        }
    }


}

class SmartMirrorApp : App() {
    override val primaryView = MirrorView::class
}