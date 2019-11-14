package id.co.dot.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.co.dot.R
import id.co.dot.entity.GalleryBatu
import kotlinx.android.synthetic.main.item_rv.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val listGalleryBatu = ArrayList<GalleryBatu>()

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setData(list: ArrayList<GalleryBatu>) {
        listGalleryBatu.clear()
        listGalleryBatu.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listGalleryBatu.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listGalleryBatu[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(galleryBatu: GalleryBatu) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(galleryBatu.image)
                    .placeholder(R.drawable.ic_broken_image_black_100dp)
                    .into(img_thumbnail)

                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(galleryBatu) }
            }
        }

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: GalleryBatu)
    }
}