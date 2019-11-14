package id.co.dot.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import id.co.dot.R

object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("setImageUrl")
    fun setImageUrl(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
            .error(R.drawable.ic_broken_image_black_100dp)
            .placeholder(R.drawable.ic_broken_image_black_100dp)
            .into(view)
    }

}