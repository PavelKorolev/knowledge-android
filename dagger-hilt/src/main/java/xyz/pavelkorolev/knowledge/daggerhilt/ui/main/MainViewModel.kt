package xyz.pavelkorolev.knowledge.daggerhilt.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class MainViewModel @ViewModelInject constructor(
    private val interactor: MainInteractor
) : ViewModel() {

    lateinit var listener: MainListener

    private var answer: String? = null
        set(value) {
            field = value
            listener.onAnswerUpdate(value)
        }

    /**
     * Fragment uses this function to restore it's state using ViewModel current state.
     */
    fun restore() {
        listener.onAnswerUpdate(answer)
    }

    fun onButtonClick() {
        val answer = interactor.giveAnswer()
        this.answer = answer
    }

}
