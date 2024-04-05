package com.example.mechuand.data.test_retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET("/api/users")
    fun getList(
        @Query("q") q: String?,
        @Query("apiKey") apiKey: String?,
        @Query("page") page: Long,
        @Query("pageSize") pageSize: Int
    ): Call<PageListModel>
}