package com.example.basic_setup

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service = Retrofit.Builder()
            .baseUrl(BuildConfig.COMIC_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        service.getIssues(20, 0, BuildConfig.API_KEY, "json", "cover_date: desc")
            .enqueue(object : Callback<BaseResponseComic<Issues>> {
                override fun onResponse(call: Call<BaseResponseComic<Issues>>, response: Response<BaseResponseComic<Issues>>) {
                    Log.d(" service_getIssues", "onResponse")
                }

                override fun onFailure(call: Call<BaseResponseComic<Issues>>, t: Throwable) {
                    Log.d(" service_getIssues", "onFailure")
                }
            })

        lifecycleScope.launch(Dispatchers.IO) {

        }

    }

    fun ImageView.loadImage(url: String) {
        if (url.isEmpty()) {
//            setImageResource(R.drawable.icon01)
        } else {
            Picasso.get()
                .load(url)
                .fit()
//                .placeholder(R.drawable.icon01)
//                .error(R.drawable.icon01)
                .centerCrop().into(this)
        }
    }
}