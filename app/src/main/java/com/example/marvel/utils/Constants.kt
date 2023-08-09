package com.example.marvel.utils

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp


class Constants {
    companion object {
        const val BASE_URL = "https://gateway.marvel.com/"
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
        const val API_KEY = "492df967b8989b11294e0c6ecdc06a88"
        const val PRIVATE_KEY = "fe5e020ea3b2375eedf3beb03f7a9a0786cbb2a6"
        const val limit = "20"
        fun hash(): String {
            val input = "$timeStamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }
    }
}