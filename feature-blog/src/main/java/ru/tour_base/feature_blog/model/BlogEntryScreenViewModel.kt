package ru.tour_base.feature_blog.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.tour_base.core_navigation.NavigationManager
import ru.tour_base.data_main.domain.entity.blog.BlogEntry
import ru.tour_base.feature_blog.usecase.GetBlogEntryUseCase
import javax.inject.Inject

@HiltViewModel
class BlogEntryScreenViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val getBlogEntryUseCase: GetBlogEntryUseCase
) : ViewModel() {

    var blogEntry by mutableStateOf<BlogEntry?>(null)

    fun getBlogEntry(blogId: Int?) {
        if (blogId != null) {
            viewModelScope.launch(Dispatchers.IO) {
                val result = getBlogEntryUseCase(blogId)

                withContext(Dispatchers.Main) {
                    when {
                        result.isError() -> {}
                        result.isLoading() -> {}
                        result.isSuccess() -> {
                            blogEntry = result.data
                        }
                    }
                }
            }
        }
    }

    fun onNavigateBack() {
        navigationManager.back()
        blogEntry = null
    }
}