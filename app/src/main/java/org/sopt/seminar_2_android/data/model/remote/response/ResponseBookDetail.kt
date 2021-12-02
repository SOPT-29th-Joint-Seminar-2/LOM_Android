package org.sopt.seminar_2_android.data.model.remote.response

import java.util.*

data class ResponseBookDetail(
    val data: Data,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val bookInfoList: BookInfoList,
        val reviewList: List<Review>
    ) {
        data class BookInfoList(
            val author: String,
            val bookImg: String,
            val bookName: String,
            val category: String,
            val completePercent: Int,
            val createdAt: String,
            val description: String,
            val id: Int,
            val postCount: Int,
            val postSize: String,
            val reviewPoint: Int,
            val updatedAt: String,
            val userStorage: String
        )

        data class Review(
            val contents: String,
            val createdAt: String,
            val id: Int,
            val likeCount: Int,
            val nickname: String,
            val updatedAt: String,
            val userImg: String
        )
    }
}