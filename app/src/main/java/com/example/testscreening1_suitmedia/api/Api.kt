package com.example.testscreening1_suitmedia.api

import com.example.testscreening1_suitmedia.model.GuestResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("596dec7f0f000023032b8017")
    fun getProfile(): Call<ArrayList<GuestResponse>>

}