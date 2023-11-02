package ru.tour_base.feature_blog.usecase

import ru.tour_base.data_main.domain.MainRepository
import javax.inject.Inject

class GetBlogEntryUseCase @Inject constructor(
    private val repository: MainRepository
) {
    suspend operator fun invoke(blogId: Int) = repository. getBlogEntry(blogId)
}