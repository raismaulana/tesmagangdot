package id.co.dot.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.dot.databinding.ItemRvBinding
import id.co.dot.entity.GalleryBatu

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
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRvBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listGalleryBatu.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listGalleryBatu[position])
    }

    inner class ViewHolder(private val binding: ItemRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(galleryBatu: GalleryBatu) {
            binding.galleryBatu = galleryBatu
            itemView.setOnClickListener { onItemClickCallback?.onItemClicked(galleryBatu) }
            binding.executePendingBindings()
        }

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: GalleryBatu)
    }
}