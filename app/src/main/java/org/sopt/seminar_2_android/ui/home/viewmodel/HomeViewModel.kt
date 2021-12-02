package org.sopt.seminar_2_android.ui.home.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.seminar_2_android.data.ApiService
import org.sopt.seminar_2_android.data.model.remote.response.ResponseBookDetail

class HomeViewModel : ViewModel() {
    var bookInfoList : MutableLiveData<ResponseBookDetail.Data.BookInfoList> = MutableLiveData()

    var reviewList : MutableLiveData<List<ResponseBookDetail.Data.Review>> = MutableLiveData()



     fun getBookDetail(bookId : Int){
        viewModelScope.launch {
            runCatching { ApiService.bookDetailService.getBookDetail(1) }
                .onSuccess {
                    bookInfoList.value = it.data.bookInfoList

                    Log.d("bookInfo", "서버 통신 성공")
                }
                .onFailure {
                    it.printStackTrace()
                    Log.d("bookInfo", "서버 통신 실패")
                }
        }
    }


}