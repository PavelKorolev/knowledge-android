package xyz.pavelkorolev.knowledge.jetpacknavigation.services

import android.graphics.Color
import androidx.annotation.ColorInt

class ColorService {

    fun darker(@ColorInt color: Int): Int {
        val hsv = FloatArray(3)
        Color.colorToHSV(color, hsv)
        hsv[2] *= 0.2f
        return Color.HSVToColor(hsv)
    }

}
