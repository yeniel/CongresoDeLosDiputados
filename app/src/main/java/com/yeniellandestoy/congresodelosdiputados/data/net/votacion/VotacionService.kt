package com.yeniellandestoy.congresodelosdiputados.data.net.votacion

import com.yeniellandestoy.congresodelosdiputados.data.dto.VotacionDto
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by yeniel on 19/2/18.
 */
interface VotacionService {

    @GET("/votaciones.json")
    fun getAll(): Observable<HashMap<String, VotacionDto>>

    @GET("/votaciones/{votacionId}.json")
    fun getByKey(@Path("votacionId") votacionId: String): Observable<VotacionDto>

}