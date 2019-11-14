package id.co.dot.entity


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GalleryBatu(

    @SerializedName("caption")
    @Expose
    val caption: String,


    @SerializedName("thumbnail")
    @Expose
    val thumbnail: String,

    @SerializedName("image")
    @Expose
    val image: String

) : Parcelable

