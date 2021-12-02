package org.sopt.seminar_2_android.data.model.remote.response

data class ResponseReviewWrite(
    val data: Data,
    val message: String,
    val status: Int,
){
    data class Data(
        val reviewId : Int
    )
}
