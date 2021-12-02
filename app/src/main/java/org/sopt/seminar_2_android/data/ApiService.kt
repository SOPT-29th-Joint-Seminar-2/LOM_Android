package org.sopt.seminar_2_android.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.sopt.seminar_2_android.data.api.BookDetailService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    private const val BASE_URL = "https://asia-northeast3-library-of-millie.cloudfunctions.net/api/"
    val gson = GsonBuilder().setLenient().create()
    val interceptor = HttpLoggingInterceptor()
    val clinet = OkHttpClient.Builder()
        .addNetworkInterceptor(interceptor)
        .addInterceptor(interceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(clinet)
        .build()



    val bookDetailService : BookDetailService = retrofit.create(BookDetailService::class.java)
}