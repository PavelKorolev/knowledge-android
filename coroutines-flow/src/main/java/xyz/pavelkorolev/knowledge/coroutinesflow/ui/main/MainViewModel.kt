package xyz.pavelkorolev.knowledge.coroutinesflow.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

@FlowPreview
class MainViewModel : ViewModel() {

    private val _events = MutableLiveData<String>()
    val events: LiveData<String> = _events

    init {
        load()
    }

    @FlowPreview
    private fun load() {
        viewModelScope.launch {
            flowOf(1, 2, 3, 4, 5)
                .map {
                    power(it)
                }
                .flowOn(Dispatchers.IO)
                .onEach {
                    _events.value = it.toString()
                }
                .collect()
        }
    }

    private suspend fun power(value: Int): Int = withContext(Dispatchers.IO) {
        delay(2000)
        value * value
    }

}
