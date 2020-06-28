package xyz.pavelkorolev.knowledge.fragmentfactory.services

import android.graphics.Color
import androidx.annotation.ColorInt
import javax.inject.Inject

class ColorService @Inject constructor() {

    fun darker(@ColorInt color: Int): Int {
        val hsv = FloatArray(3)
        Color.colorToHSV(color, hsv)
        hsv[2] *= 0.2f
        return Color.HSVToColor(hsv)
    }

}
