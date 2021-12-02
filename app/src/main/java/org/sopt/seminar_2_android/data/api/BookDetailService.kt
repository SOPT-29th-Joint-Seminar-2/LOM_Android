package org.sopt.seminar_2_android.data.api

import org.sopt.seminar_2_android.data.model.remote.request.RequestContent
import org.sopt.seminar_2_android.data.model.remote.response.ResponseBookDetail
import org.sopt.seminar_2_android.data.model.remote.response.ResponseReviewLike
import org.sopt.seminar_2_android.data.model.remote.response.ResponseReviewWrite
import retrofit2.http.*

interface BookDetailService{
    @GET("book/{bookId}")
    suspend fun getBookDetail(
        @Path("bookId") bookId : Int
    ) : ResponseBookDetail

    @PUT("review/{reviewId}")
    suspend fun putReviewLike(
        @Path("reviewId") reviewId : Int
    ) : ResponseReviewLike


    @POST("review")
    suspend fun postReviewWrite(
        @Body requestContent : RequestContent
    ) : ResponseReviewWrite
}


