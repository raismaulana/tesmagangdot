package id.co.dot

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import id.co.dot.adapter.MainAdapter
import id.co.dot.entity.GalleryBatu
import id.co.dot.helper.CONSTANT
import id.co.dot.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showLoading(true)
        showRecycler()

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.getGalleryBatu().observe(this, Observer { listData ->
            if (listData != null) {
                showLoading(false)
                Log.d("response body", listData.toString())
                adapter.setData(listData)
            }
        })

        viewModel.setData()
    }

    private fun showRecycler() {
        adapter = MainAdapter()
        adapter.notifyDataSetChanged()

        rv_main.layoutManager = StaggeredGridLayoutManager(3, 1)
        rv_main.adapter = adapter

        adapter.setOnItemClickCallback(object : MainAdapter.OnItemClickCallback {
            override fun onItemClicked(data: GalleryBatu) {
                val parcel = GalleryBatu(data.caption, data.thumbnail, data.image)
                val mIntent = Intent(this@MainActivity, DetailActivity::class.java)
                mIntent.putExtra(CONSTANT.EXTRA_DETAIL, parcel)
                startActivity(mIntent)
            }

        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progress_bar.visibility = View.VISIBLE
        } else {
            progress_bar.visibility = View.GONE
        }
    }
}
