//package com.example.talha.jsonparsing.util
//
//import android.app.PendingIntent.getActivity
//import java.io.IOException
//
//class ReadWrite {
//    fun loadJSONFromAsset(): String {
//        var json: String? = null
//        try {
//            val `is` = getActivity().getAssets().open("test.json")
//            val size = `is`.available()
//            val buffer = ByteArray(size)
//            `is`.read(buffer)
//            `is`.close()
//            json = String(buffer, "UTF-8")
//        } catch (ex: IOException) {
//            ex.printStackTrace()
//            return null
//        }
//
//        return json
//    }
//}