package org.sopt.seminar_2_android.ui.home

import retrofit2.Call
import retrofit2.http.*

interface LOMService {

    @GET("book")
    fun getInfo() : Call<ResponseLOMData>

}