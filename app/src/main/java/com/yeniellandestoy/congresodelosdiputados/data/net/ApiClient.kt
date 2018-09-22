package com.yeniellandestoy.congresodelosdiputados.data.net

import rx.Observable

/**
 * Created by yeniel on 19/2/18.
 */
interface ApiClient<T, K> {

    val BASE_URL: String
        get() = "https://com-yeniellandestoy-congreso.firebaseio.com"

    fun getAll(): Observable<List<T>>

    fun getByKey(key: K): Observable<T>

}