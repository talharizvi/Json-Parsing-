package com.example.talha.jsonparsing


    data class UserInfo(
            val timestamp: String,
            val code: String,
            val message: String,
            val path: String,
            val data: ArrayList<Data>,
            val errorDetail: Any
    )




