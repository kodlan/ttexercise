package com.sbardyuk.ttexercise.ttexercise.data

import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiEndpointInterface {

    @GET("users.json")
    fun userList(): Call<List<User>>


    companion object Factory {
        fun create(): ApiEndpointInterface {
            // TODO: move this to dependency injection
            val gson = GsonBuilder().create()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://media.tictrac.com/tmp/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(ApiEndpointInterface::class.java)

        }
    }
}