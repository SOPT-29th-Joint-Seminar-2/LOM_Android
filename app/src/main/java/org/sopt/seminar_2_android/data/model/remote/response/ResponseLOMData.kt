package org.sopt.seminar_2_android.data.model.remote.response

data class ResponseLOMData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<Data>
)
{
    data class Data(
        val bookId: Int,
        val bookImg: String,
        val bookName : String,
        val author : String
    )
}

