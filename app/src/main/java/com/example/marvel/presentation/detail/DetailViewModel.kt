package com.example.marvel.presentation.detail


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel.domain.model.CharacterModel
import com.example.marvel.domain.use_cases.CharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DetailViewModel(
    private val characterUseCase: CharacterUseCase
) : ViewModel() {
    var state by mutableStateOf(DetailState())
        private set

    private val _character = MutableLiveData<CharacterModel>()
    val character: LiveData<CharacterModel> get() = _character

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage




  fun getCharacter (id: String) = viewModelScope.launch {

        try {
            val result = withContext(Dispatchers.IO) {
                characterUseCase.invoke(id)
            }
            _character.value = result
        } catch (_: Throwable) {
            _errorMessage.value = "Error lunched from ViewModel"
        }
    }
}

