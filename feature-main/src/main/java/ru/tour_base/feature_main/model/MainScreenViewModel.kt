package ru.tour_base.feature_main.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.tour_base.data_main.domain.entity.main.MainContent
import ru.tour_base.feature_main.usecase.GetMainContentUseCase
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getMainContentUseCase: GetMainContentUseCase
) : ViewModel() {

    private var _mainContent = MutableStateFlow<MainContent?>(null)
    val mainContent: Flow<MainContent?> = _mainContent

    init {
        getMainScreenContent()
    }

    private fun getMainScreenContent() {
        viewModelScope.launch(Dispatchers.IO) {
            val content = getMainContentUseCase()

            when {
                content.isError() -> {  }
                content.isLoading() -> {  }
                content.isSuccess() -> {
                    _mainContent.value = content.data
                }
            }
        }
    }
}