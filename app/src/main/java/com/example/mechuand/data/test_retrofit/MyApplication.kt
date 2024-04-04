package com.example.mechuand.data.test_retrofit

import android.app.Application
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MyApplication : Application() {
    companion object {
        var networkService: NetworkService

        val BASE_URL = "http://localhost:8029/api/users"

        init {
            networkService = retrofit.create(NetworkService::class.java)
        }

        val QUERY = "travel"
        val API_KEY = "079dac74a5f94ebdb990ecf61c8854b7"
        val USER_AGENT =
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36"

        val retrofit: Retrofit get() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
