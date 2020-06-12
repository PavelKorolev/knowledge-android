package xyz.pavelkorolev.knowledge.service

import xyz.pavelkorolev.knowledge.R
import xyz.pavelkorolev.knowledge.core.ResourceProvider
import javax.inject.Inject

interface EightBallService {

    fun giveAnswer(): String

}

class EightBallServiceImpl @Inject constructor(
    resourceProvider: ResourceProvider
) : EightBallService {

    private val answers = resourceProvider.getStringArray(R.array.eight_ball_answers)

    override fun giveAnswer(): String = answers.random()

}
