package ru.tour_base.data_main.data

import ru.tour_base.core.AppError
import ru.tour_base.core.Either
import ru.tour_base.data_main.data.mappers.toDomain
import ru.tour_base.data_main.domain.MainRepository
import ru.tour_base.data_main.domain.entity.blog.BlogEntry
import ru.tour_base.data_main.domain.entity.main.MainContent
import ru.tour_base.data_main.network.MainApi
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainApi: MainApi
) : MainRepository {

    override suspend fun getMainContent(): Either<MainContent> {
        val result = mainApi.getMainContent()

        return when {
            result.isError() -> Either.error(result.error ?: AppError.Unknown())
            result.isSuccess() -> Either.success(result.data?.toDomain())
            else -> Either.loading()
        }
    }

    override suspend fun getBlogEntry(entryUrl: String): Either<BlogEntry> {
        val result = mainApi.getBlogEntry(entryUrl)

        return when {
            result.isError() -> Either.error(result.error ?: AppError.Unknown())
            result.isSuccess() -> Either.success(result.data?.toDomain())
            else -> Either.loading()
        }
    }
}