package id.co.dot.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GalleryBatu(

    @SerializedName("image")
    @Expose
    val image: String? = null,

    @SerializedName("thumbnail")
    @Expose
    val thumbnail: String? = null,

    @SerializedName("caption")
    @Expose
    val caption: String? = null
) : Parcelable