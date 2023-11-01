package ru.tour_base.data_main.domain

import ru.tour_base.core.Either
import ru.tour_base.data_main.domain.entity.blog.BlogEntry
import ru.tour_base.data_main.domain.entity.main.MainContent

interface MainRepository {

    suspend fun getMainContent(): Either<MainContent>
    suspend fun getBlogEntry(entryUrl: String): Either<BlogEntry>
}