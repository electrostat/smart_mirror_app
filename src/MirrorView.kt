/**
 * Created by Anthony-Parkour on 6/9/19.
 */
package SmartMirror

import javafx.geometry.Pos
import javafx.scene.layout.BackgroundRepeat
import javafx.scene.paint.Color
import javafx.scene.text.Font
import tornadofx.*

class MirrorView : View() {
    override val root = vbox {
        style {
            backgroundColor = multi(Color.BLACK)
            backgroundRepeat = multi(BackgroundRepeat.NO_REPEAT
                    to BackgroundRepeat.NO_REPEAT)
            textFill = Color.WHITE
        }
        prefWidth = 500.0
        prefHeight = 300.0

        spacing = 20.0
        padding = insets(50, 20)
        text("A text") {
            font = Font.font(40.0)
            alignment = Pos.CENTER
            fill = Color.WHITE

        }

        button("OK")
        {
            font = Font.font(20.0)
            action {
                close()
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