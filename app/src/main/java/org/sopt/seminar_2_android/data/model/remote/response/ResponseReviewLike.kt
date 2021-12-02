package org.sopt.seminar_2_android.data.model.remote.response

data class ResponseReviewLike(
    val data: Data,
    val message: String,
    val status: Int,
){
    data class Data(
        val like : Int
    )
}
