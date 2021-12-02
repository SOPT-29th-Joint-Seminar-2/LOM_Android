package org.sopt.seminar_2_android.data.api

import org.sopt.seminar_2_android.data.model.remote.response.ResponseBookDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookDetailService{
    @GET("book/{bookId}")
    suspend fun getBookDetail(
        @Path("bookId") bookId : Int
    ) : ResponseBookDetail
}


