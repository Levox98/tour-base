package ru.tour_base.data_main.domain

import ru.tour_base.core.Either
import ru.tour_base.data_main.domain.entity.blog.BlogElement
import ru.tour_base.data_main.domain.entity.main.MainContent

interface MainRepository {

    suspend fun getMainContent(): Either<MainContent>
    suspend fun getBlogContent(contentUrl: String): Either<List<BlogElement>>
}