package xyz.pavelkorolev.knowledge.service

import xyz.pavelkorolev.knowledge.R
import xyz.pavelkorolev.knowledge.core.ResourceProvider

interface EightBallService {

    fun giveAnswer(): String

}

class EightBallServiceImpl(
    resourceProvider: ResourceProvider
) : EightBallService {

    private val answers = resourceProvider.getStringArray(R.array.eight_ball_answers)

    override fun giveAnswer(): String = answers.random()

}
