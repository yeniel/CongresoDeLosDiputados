package com.yeniellandestoy.congresodelosdiputados.data.repository.datasource

import rx.Observable

/**
 * Created by yeniel on 20/2/18.
 */
interface DataSource<T, K> {

    fun getAll(): Observable<List<T>>

    fun getByKey(key: K): Observable<T>

}