package xyz.pavelkorolev.knowledge.ui.main

import xyz.pavelkorolev.knowledge.service.EightBallService
import javax.inject.Inject

class MainInteractor @Inject constructor(
    private val eightBallService: EightBallService
) {

    fun giveAnswer(): String = eightBallService.giveAnswer()

}
