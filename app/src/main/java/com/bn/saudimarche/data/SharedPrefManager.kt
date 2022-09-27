package com.bn.saudimarche.data

import android.content.Context
import com.bn.saudimarche.data.model.user.UserModel
import com.google.gson.Gson

class SharedPrefManager(private var mContext: Context) {
    companion object {
        const val APP_LANGUAGE = "SAUDI_MARCHE_APP_LANGUAGE"
        const val SHARED_PREF_NAME = "SAUDI_MARCHE_APP_SHARE_PREF"
        const val DISTANCE = "DISTANCE"
        const val WAITING_TIME = "WAITING_TIME"
        const val USER_MODEL = "SAUDI_MARCHE_USER_MODEL"
        const val LOGIN_STATUS = "SAUDI_MARCHE_LOGIN_STATUS"
    }


    private var mSharedPreferences =
        mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    var loginStatus: Boolean
        get() = mSharedPreferences.getBoolean(LOGIN_STATUS, false)
        set(status) {
            mSharedPreferences.edit().putBoolean(LOGIN_STATUS, status).apply()
        }

    var appLanguage: String?
        get() = mSharedPreferences.getString(APP_LANGUAGE, "en")
        set(appLanguage) {
            mSharedPreferences.edit().putString(APP_LANGUAGE, appLanguage).apply()
        }
    var userData: UserModel
        get() = Gson().fromJson(
            mSharedPreferences.getString(USER_MODEL, Gson().toJson(UserModel())),
            UserModel::class.java
        )
        set(userModel) {
            mSharedPreferences.edit().putString(USER_MODEL, Gson().toJson(userModel)).apply()
        }

    fun logout() {
        mSharedPreferences.edit().clear().apply()
    }
}