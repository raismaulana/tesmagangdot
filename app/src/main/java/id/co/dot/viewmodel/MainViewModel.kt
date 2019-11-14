package id.co.dot.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.dot.entity.GalleryBatu
import id.co.dot.networking.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val listGalleryBatu = MutableLiveData<ArrayList<GalleryBatu>>()

    internal fun setData() {
        ApiService().services.getGalleryBatu()
            .enqueue(object : Callback<ArrayList<GalleryBatu>> {
                override fun onFailure(call: Call<ArrayList<GalleryBatu>>, t: Throwable) {
                    Log.e("Failure", t.message.toString(), t)
                }

                override fun onResponse(
                    call: Call<ArrayList<GalleryBatu>>,
                    response: Response<ArrayList<GalleryBatu>>
                ) {
                    listGalleryBatu.postValue(response.body())
                }
            })
    }

    internal fun getGalleryBatu(): LiveData<ArrayList<GalleryBatu>> {
        return listGalleryBatu
    }
}