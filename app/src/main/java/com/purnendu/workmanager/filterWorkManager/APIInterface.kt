package com.purnendu.workmanager.filterWorkManager

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

interface APIInterface {

    @GET("/69786552/103311362-2b50a580-4a40-11eb-8638-b88dea1a18b7.jpeg")
    suspend fun imageDownload():Response<ResponseBody>

    companion object {
        val retrofitInstance: APIInterface by lazy {
            Retrofit.Builder()
                .baseUrl("https://user-images.githubusercontent.com")
                .build()
                .create(APIInterface::class.java)
        }
    }
}

