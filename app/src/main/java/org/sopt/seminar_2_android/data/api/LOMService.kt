package org.sopt.seminar_2_android.data.api

import org.sopt.seminar_2_android.data.model.remote.response.ResponseLOMData
import retrofit2.Call
import retrofit2.http.*

interface LOMService {

    @GET("book")
    fun getInfo() : Call<ResponseLOMData>

}