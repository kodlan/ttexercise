package com.sbardyuk.ttexercise.ttexercise.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserService {

    fun getListData(onListDataReadyCallback: OnListDataReadyCallback) {

        val api = ApiEndpointInterface.create()

        val call = api.userList()
        call.enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                TODO("not implemented")
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful && response.body() != null) {
                    onListDataReadyCallback.onDataReady(response.body()!!)
                } else {
                    TODO("not implemented")
                }
            }

        })

    }
}

interface OnListDataReadyCallback {
    fun onDataReady(data: List<User>)
}