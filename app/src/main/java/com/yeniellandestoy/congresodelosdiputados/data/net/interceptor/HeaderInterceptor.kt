package com.yeniellandestoy.congresodelosdiputados.data.net.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

/**
 * Created by yeniel on 19/2/18.
 */
class HeaderInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()

        addHeaders(builder)

        return chain.proceed(builder.build())
    }

    protected fun addHeaders(builder: Request.Builder) {
        builder.addHeader("Accept", "application/json")
                .addHeader("User-Agent", "Android-Retrofit")
    }
}