package xyz.pavelkorolev.knowledge.jetpacknavigation.ui.registration

import androidx.lifecycle.ViewModel

class RegistrationViewModel : ViewModel() {

    var name: String? = null

    fun isOk(): Boolean {
        return name != null
    }

}
