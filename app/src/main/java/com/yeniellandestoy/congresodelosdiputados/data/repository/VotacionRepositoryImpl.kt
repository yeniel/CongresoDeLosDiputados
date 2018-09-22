package com.yeniellandestoy.congresodelosdiputados.data.repository

import com.yeniellandestoy.congresodelosdiputados.data.repository.datasource.votacion.NetworkVotacionDataSource
import com.yeniellandestoy.congresodelosdiputados.domain.model.Votacion
import com.yeniellandestoy.congresodelosdiputados.domain.repository.VotacionRepository
import rx.Observable
import javax.inject.Inject

/**
 * Created by yeniel on 20/2/18.
 */
class VotacionRepositoryImpl @Inject constructor(private val networkDataSource: NetworkVotacionDataSource) : VotacionRepository {

    override fun getAll(): Observable<List<Votacion>> {
        return networkDataSource.getAll()
    }

    override fun getByKey(key: String): Observable<Votacion> {
        return networkDataSource.getByKey(key)
    }
}