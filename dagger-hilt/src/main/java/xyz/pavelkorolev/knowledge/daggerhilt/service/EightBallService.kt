package xyz.pavelkorolev.knowledge.daggerhilt.service

import xyz.pavelkorolev.knowledge.core.ResourceProvider
import xyz.pavelkorolev.knowledge.daggerhilt.R
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
