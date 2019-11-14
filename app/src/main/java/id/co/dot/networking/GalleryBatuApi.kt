package id.co.dot.networking

import id.co.dot.entity.GalleryBatu
import retrofit2.Call
import retrofit2.http.GET

interface GalleryBatuApi {
    @GET("Gallery_Malang_Batu.json")
    fun getGalleryBatu(): Call<ArrayList<GalleryBatu>>
}