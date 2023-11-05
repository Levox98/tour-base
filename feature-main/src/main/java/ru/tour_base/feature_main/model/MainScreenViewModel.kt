package ru.tour_base.feature_main.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.tour_base.core_navigation.BlogNavScreen
import ru.tour_base.core_navigation.NavigationManager
import ru.tour_base.data_main.domain.entity.blog.BlogElement
import ru.tour_base.data_main.domain.entity.main.MainContent
import ru.tour_base.feature_main.usecase.GetBlogContentBlockUseCase
import ru.tour_base.feature_main.usecase.GetMainContentUseCase
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val getMainContentUseCase: GetMainContentUseCase,
    private val getBlogContentBlockUseCase: GetBlogContentBlockUseCase
) : ViewModel() {

    private var _mainContent = MutableStateFlow<MainContent?>(null)
    val mainContent: Flow<MainContent?> = _mainContent

//    private var _blogElements = MutableStateFlow<List<BlogElement>?>(null)
    var blogElements by mutableStateOf<List<BlogElement>?>(null)
        private set

    init {
        getMainScreenContent()
    }

    fun navigateToBlog(blogId: Int) {
        navigationManager.navigate(BlogNavScreen.Blog(blogId))
    }

    private fun getMainScreenContent() {
        viewModelScope.launch(Dispatchers.IO) {
            val content = getMainContentUseCase()

            when {
                content.isError() -> {}
                content.isLoading() -> {}
                content.isSuccess() -> {
                    _mainContent.value = content.data
                    getBlogContent(
                        _mainContent.value?.content?.firstOrNull {
                            it.template.objectName == "blog"
                        }?.url
                    )
                }
            }
        }
    }

    private suspend fun getBlogContent(url: String?) {
        if (url != null) {

            val result = getBlogContentBlockUseCase(url)

            when {
                result.isError() -> {}
                result.isLoading() -> {}
                result.isSuccess() -> {
                    blogElements = result.data
                }
            }
        }
    }
}