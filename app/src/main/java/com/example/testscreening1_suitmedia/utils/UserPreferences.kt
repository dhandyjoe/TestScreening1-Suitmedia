package com.example.testscreening1_suitmedia.utils

import android.content.Context

class UserPreferences (context: Context) {

    companion object {
        const val NAME_CUSTOMER = "NAME_CUSTOMER"
        const val NAME_EVENT = "NAME_EVENT"
        const val NAME_GUEST = "NAME_GUEST"
        const val STATUS_EVENT = "STATUS_EVENT"
        const val STATUS_GUEST = "STATUS_GUEST"
    }

    private val preferences = context.getSharedPreferences(NAME_CUSTOMER, Context.MODE_PRIVATE)

    fun setNameCustomer (string: String) {
        val editor = preferences.edit()
        editor.putString(NAME_CUSTOMER, string)
        editor.apply()
    }

    fun getNameCustomer (): String? {
        return preferences.getString(NAME_CUSTOMER, "")
    }

    fun setNameEvent (string: String) {
        val editor = preferences.edit()
        editor.putString(NAME_EVENT, string)
        editor.apply()
    }

    fun getNameEvent (): String? {
        return preferences.getString(NAME_EVENT, "")
    }


    fun setStatusEvent (boolean: Boolean) {
        val editor = preferences.edit()
        editor.putBoolean(STATUS_EVENT, boolean)
        editor.apply()
    }

    fun getStatusEvent (): Boolean {
        return preferences.getBoolean(STATUS_EVENT, false)
    }

    fun setNameGuest (string: String) {
        val editor = preferences.edit()
        editor.putString(NAME_GUEST, string)
        editor.apply()
    }

    fun getNameGuest (): String? {
        return preferences.getString(NAME_GUEST, "")
    }

    fun setStatusGuest (boolean: Boolean) {
        val editor = preferences.edit()
        editor.putBoolean(STATUS_GUEST, boolean)
        editor.apply()
    }

    fun getStatusGuest (): Boolean {
        return preferences.getBoolean(STATUS_GUEST, false)
    }

    fun deleteAllData () {
        val delete = preferences.edit().clear().apply()
    }



}