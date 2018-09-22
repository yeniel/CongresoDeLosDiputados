package com.yeniellandestoy.congresodelosdiputados.data.net.votacion

import com.yeniellandestoy.congresodelosdiputados.data.dto.VotacionDto
import com.yeniellandestoy.congresodelosdiputados.data.net.ApiClient
import com.yeniellandestoy.congresodelosdiputados.data.net.RetrofitBuilder
import rx.Observable
import java.util.*
import javax.inject.Inject

/**
 * Created by yeniel on 19/2/18.
 */
class VotacionApiClient @Inject constructor() : ApiClient<VotacionDto, String> {

    val retrofitService = RetrofitBuilder.createDefaultRetrofit(BASE_URL).create(VotacionService::class.java)

    override fun getAll(): Observable<List<VotacionDto>> {
        return retrofitService.getAll().map {
            val list = ArrayList<VotacionDto>()

            for ((_, value) in it) {
                list.add(value)
            }

            list
        }
    }

    override fun getByKey(key: String): Observable<VotacionDto> {
        return retrofitService.getByKey(key)
    }

}