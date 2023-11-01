package ru.tour_base.core_network

import android.util.Log
import retrofit2.Response
import ru.tour_base.core.AppError
import ru.tour_base.core.Either

abstract class BaseApi {

    suspend fun <E, R> doRequest(
        tag: String = "",
        request: suspend () -> Response<R>,
        mapper: suspend (R?) -> E?,
    ): Either<E> {
        return try {
            val response = request()
            if (response.isSuccessful) {
                val result = response.body() as ApiResponse
                if (result.error == null && result.success) {
                    Either.success(mapper(response.body()))
                } else {
                    if (result.error != null) {
                        Either.error(
                            AppError.error(result.error?.code?.toInt() ?: -1, result.error?.message ?: "")
                        )
                    } else {
                        Either.error(AppError.Unknown("Unknown error"))
                    }
                }
            } else {
                Either.error(AppError.Unknown("Response unsuccessful"))
            }
        } catch (e: Exception) {
            Log.e("API_ERROR | $tag", "${e.message}")
            Either.error(AppError.Unknown(e.message ?: ""))
        }
    }
}