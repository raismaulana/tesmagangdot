package id.co.dot

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import id.co.dot.databinding.ActivityDetailBinding
import id.co.dot.entity.GalleryBatu
import id.co.dot.helper.CONSTANT
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail)

        toolbar.setTitle(R.string.app_name)
        toolbar.elevation = 4.0f
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
        toolbar.setNavigationOnClickListener { onBackPressed() }

        binding.galleryBatu = intent.getParcelableExtra(CONSTANT.EXTRA_DETAIL) as GalleryBatu

    }
}
