package com.example.retrofitdemo

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {

    companion object {
        val BASE_URL = "https://jsonplaceholder.typicode.com"

        // logging interceptor...(logs the info about the OkHttp call)
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS) // connectTimeout is the time-period in which our app should establish a connection with the server(by default it is -> 10sec)
                .readTimeout(20, TimeUnit.SECONDS) // readTimeout -> defined as maximum time gap between arrivals of two data-packets when waiting for server's response.
                .writeTimeout(25, TimeUnit.SECONDS) // writeTimeout -> defined as maximum time-gap b/w two data-packets when sending them to the server.
        }.build()

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    }
}