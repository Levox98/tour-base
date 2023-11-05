package ru.tour_base.feature_main.usecase

import ru.tour_base.data_main.domain.MainRepository
import javax.inject.Inject

class GetBlogContentBlockUseCase @Inject constructor(
    private val repository: MainRepository
) {
    suspend operator fun invoke(contentUrl: String) = repository.getBlogContent(contentUrl)
}