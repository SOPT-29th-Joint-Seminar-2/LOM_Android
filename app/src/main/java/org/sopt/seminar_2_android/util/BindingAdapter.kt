package org.sopt.seminar_2_android.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import org.sopt.seminar_2_android.R

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("imgBind")
    fun setImage(imageView: ImageView, imageUrl: String?) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .fallback(R.drawable.book1)
            .into(imageView)
    }

    @JvmStatic
    @BindingAdapter("intToText")
    fun getIntToText(textView: TextView, int : Int) : String{
        return int.toString().also { textView.text = it }
    }
}