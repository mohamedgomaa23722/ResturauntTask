package com.gomaa.resturanttask.di.Modules

import com.gomaa.resturanttask.di.annotations.AuthBody
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.RequestBody
import org.json.JSONObject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HolderBody {

    @AuthBody
    @Singleton
    @Provides
    fun generatedBody():RequestBody{
        val body = JSONObject()
        body.put("googleId", "ChIJ88rv8bI_WBQRkvVBLDeZQUg")
        return RequestBody.create(
            okhttp3.MediaType.parse("application/json; charset=utf-8"),
            (body).toString())
    }

}