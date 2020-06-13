package xyz.pavelkorolev.knowledge.daggerhilt.ui.main

import xyz.pavelkorolev.knowledge.daggerhilt.service.EightBallService
import javax.inject.Inject

class MainInteractor @Inject constructor(
    private val eightBallService: EightBallService
) {

    fun giveAnswer(): String = eightBallService.giveAnswer()

}
