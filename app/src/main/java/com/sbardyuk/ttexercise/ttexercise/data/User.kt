package com.sbardyuk.ttexercise.ttexercise.data

import com.google.gson.annotations.SerializedName

data class User(val name: String, val email: String, val infos: String,
                @SerializedName("profile_picture") val profilePicture: String)