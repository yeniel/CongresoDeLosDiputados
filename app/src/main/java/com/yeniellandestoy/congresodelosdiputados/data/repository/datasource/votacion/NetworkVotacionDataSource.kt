package com.yeniellandestoy.congresodelosdiputados.data.repository.datasource.votacion

import com.yeniellandestoy.congresodelosdiputados.data.dto.VotacionDto
import com.yeniellandestoy.congresodelosdiputados.data.dto.mapper.VotacionDtoMapper
import com.yeniellandestoy.congresodelosdiputados.data.net.ApiClient
import com.yeniellandestoy.congresodelosdiputados.domain.model.Votacion
import rx.Observable
import javax.inject.Inject

/**
 * Created by yeniel on 20/2/18.
 */
class NetworkVotacionDataSource @Inject constructor(private val apiClient: ApiClient<VotacionDto, String>,
                                                    private val mapper: VotacionDtoMapper) : VotacionDataSource {

    override fun getAll(): Observable<List<Votacion>> {
        return apiClient.getAll().map {
            mapper.transform(it)
        }
    }

    override fun getByKey(key: String): Observable<Votacion> {
        return apiClient.getByKey(key).map { mapper.transform(it) }
    }

}