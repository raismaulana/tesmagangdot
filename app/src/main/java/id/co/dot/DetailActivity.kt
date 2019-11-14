package id.co.dot

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import id.co.dot.entity.GalleryBatu
import id.co.dot.helper.CONSTANT
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val parcel = intent.getParcelableExtra(CONSTANT.EXTRA_DETAIL) as GalleryBatu

        txt_caption.text = parcel.caption

        Glide.with(this)
            .load(parcel.image)
            .error(R.drawable.ic_broken_image_black_100dp)
            .placeholder(R.drawable.ic_broken_image_black_100dp)
            .into(img_image)

    }
}
