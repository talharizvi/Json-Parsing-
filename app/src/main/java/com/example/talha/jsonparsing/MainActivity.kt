package com.example.talha.jsonparsing

import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.nio.charset.Charset
import java.util.ArrayList

class MainActivity:AppCompatActivity() {

    //val list = ArrayList<String>()
    val list2 = ArrayList<Data>()
    val list3 = ArrayList<UserInfo>()
    lateinit var listUserInfo:UserInfo
    var listData=ArrayList<Data>()
    var a:Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadJSONFromAsset()
    }

    fun loadJSONFromAsset(): String? {
        val charset: Charset = Charsets.UTF_8
        var json: String? = null
        try {
            val `is` = getAssets().open("jsonfile.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
          json = String(buffer,charset)
            val gsonBuilder = GsonBuilder()
            gsonBuilder.serializeNulls()
            val gson = gsonBuilder.create()
            val userInfo:UserInfo = gson.fromJson(json,UserInfo::class.java)
           // Log.d("json obj",userInfo.toString())
            //var jsonArray = JSONArray(json)
            list3.add(userInfo)
            val datalist = userInfo.data
            list2.addAll(datalist)
            Log.d("size",list3.size.toString())
            for (i in 0 until list2.size){
                //var obj:UserInfo = json.get(i) as UserInfo
                //Log.d("value",obj.toString())
                //list.add(obj.toString())
                //list3.add(obj)
                //listData = list3.get(i).data
                a = datalist.get(i).userId

            }

          //  Log.d("listdata",listData.toString())
            Log.d("userid",a.toString())
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }
}