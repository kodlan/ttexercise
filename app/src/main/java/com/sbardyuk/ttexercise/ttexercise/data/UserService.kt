package com.sbardyuk.ttexercise.ttexercise.data

import android.os.Handler

class UserService {

    fun getListData(onListDataReadyCallback: OnListDataReadyCallback) {
        val list = arrayListOf(
            User("test1", "email@email.com", "infos11", "http://picture1.jpg"),
            User("test3", "email@email.com", "infos22", "http://picture2.jpg"),
            User("test5", "email@email.com", "infos33", "http://picture3.jpg"))
        Handler().postDelayed({ onListDataReadyCallback.onDataReady(list)}, 2000)
    }
}

interface OnListDataReadyCallback {
    fun onDataReady(data: List<User>)
}