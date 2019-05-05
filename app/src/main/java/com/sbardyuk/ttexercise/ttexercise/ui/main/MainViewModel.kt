package com.sbardyuk.ttexercise.ttexercise.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.sbardyuk.ttexercise.ttexercise.data.OnListDataReadyCallback
import com.sbardyuk.ttexercise.ttexercise.data.User
import com.sbardyuk.ttexercise.ttexercise.data.UserService
import java.util.*


class MainViewModel : ViewModel() {

    var userService = UserService()

    var listLiveData = MutableLiveData<ArrayList<User>>()
    var isLoading = ObservableField<Boolean> ()

    fun loadListData() {
        isLoading.set(true)

        userService.getListData(object : OnListDataReadyCallback {
            override fun onDataReady(data: List<User>) {
                isLoading.set(false)
                listLiveData.value = ArrayList(data)
            }

        })
    }
}
