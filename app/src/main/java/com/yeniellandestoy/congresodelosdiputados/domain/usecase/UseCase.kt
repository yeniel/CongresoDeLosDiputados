package com.yeniellandestoy.congresodelosdiputados.domain.usecase

import com.yeniellandestoy.congresodelosdiputados.domain.executor.PostExecutionThread
import com.yeniellandestoy.congresodelosdiputados.domain.executor.ThreadExecutor
import rx.Observable
import rx.Subscriber
import rx.schedulers.Schedulers
import rx.subscriptions.Subscriptions

/**
 * Created by yeniel on 28/2/18.
 */

abstract class UseCase<T, Params> protected constructor(private val threadExecutor: ThreadExecutor, private val postExecutionThread: PostExecutionThread) {

    private var subscription = Subscriptions.empty()

    protected abstract fun buildUseCaseObservable(params: Params): Observable<T>

    fun execute(useCaseSubscriber: Subscriber<T>, params: Params) {
        this.subscription = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
                .subscribe(useCaseSubscriber)
    }

    fun unsubscribe() {
        if (!subscription.isUnsubscribed) {
            subscription.unsubscribe()
        }
    }

}