package com.yeniellandestoy.congresodelosdiputados.domain.repository

import rx.Observable

/**
 * Created by yeniel on 20/2/18.
 */
interface Repository<T, K> {

    fun getAll(): Observable<List<T>>

    fun getByKey(key: K): Observable<T>

}