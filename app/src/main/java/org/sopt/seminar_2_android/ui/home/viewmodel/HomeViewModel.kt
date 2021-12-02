package org.sopt.seminar_2_android.ui.home.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.seminar_2_android.data.ApiService
import org.sopt.seminar_2_android.data.model.remote.request.RequestContent
import org.sopt.seminar_2_android.data.model.remote.response.ResponseBookDetail

class HomeViewModel : ViewModel() {
    var bookInfoList : MutableLiveData<ResponseBookDetail.Data.BookInfoList> = MutableLiveData()

    var reviewList : MutableLiveData<List<ResponseBookDetail.Data.Review>> = MutableLiveData()

    var reviewLikeCount : MutableLiveData<Int> = MutableLiveData()

    var reviewId : MutableLiveData<Int> = MutableLiveData()

     fun getBookDetail(bookId : Int){
        viewModelScope.launch {
            runCatching { ApiService.bookDetailService.getBookDetail(1) }
                .onSuccess {
                    bookInfoList.value = it.data.bookInfoList
                    reviewList.value = it.data.reviewList
                    Log.d("bookInfo", "서버 통신 성공")
                }
                .onFailure {
                    it.printStackTrace()
                    Log.d("bookInfo", "서버 통신 실패")
                }
        }
    }

    fun putLikeCount(id : Int){
        viewModelScope.launch {
            runCatching { ApiService.bookDetailService.putReviewLike(id) }
                .onSuccess {
                    reviewLikeCount.value = it.data.like
                    Log.d("reviewLikeCount", "서버 통신 성공")
                }
                .onFailure {
                    it.printStackTrace()
                    Log.d("reviewLikeCount", "서버 통신 실패")
                }

        }


    }

    fun postReviewWrite(text : String){
        viewModelScope.launch {
            runCatching { ApiService.bookDetailService.postReviewWrite(RequestContent(text)) }
                .onSuccess {
                    reviewId.value = it.data.reviewId
                    Log.d("reviewWrite", "서버 통신 성공")
                }
                .onFailure {
                    it.printStackTrace()
                    Log.d("reviewWrite", "서버 통신 실패")
                }
        }
    }


}