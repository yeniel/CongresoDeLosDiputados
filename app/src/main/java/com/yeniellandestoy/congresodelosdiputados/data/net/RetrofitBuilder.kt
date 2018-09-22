package com.yeniellandestoy.congresodelosdiputados.data.net

import com.yeniellandestoy.congresodelosdiputados.data.net.interceptor.HeaderInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by yeniel on 19/2/18.
 */
class RetrofitBuilder {

    companion object {

        private val REQUEST_TIMEOUT = 30

        fun createDefaultRetrofit(baseUrl: String): Retrofit {
            return createRetrofit(baseUrl, getBuilder())
        }

        fun createRetrofit(baseUrl: String,
                           vararg interceptors: Interceptor): Retrofit {
            val builder = getBuilder()

            for (interceptor in interceptors) {
                builder.addInterceptor(interceptor)
            }

            return createRetrofit(baseUrl, builder)
        }

        private fun addDefaultInterceptorsToBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder {
            builder.addInterceptor(HeaderInterceptor())

            return builder
        }

        private fun getBuilder(): OkHttpClient.Builder {
            val builder = OkHttpClient.Builder()
                    .connectTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .readTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)

            return addDefaultInterceptorsToBuilder(builder)
        }

        private fun createRetrofit(baseUrl: String, builder: OkHttpClient.Builder): Retrofit {

            val okHttpBuilder = addLoggingInterceptorToBuilder(builder)

            return Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpBuilder.build())
                    .build()
        }

        private fun addLoggingInterceptorToBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder {
            val loggingInterceptor = HttpLoggingInterceptor()

            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            builder.addInterceptor(loggingInterceptor)

            return builder
        }

    }

}