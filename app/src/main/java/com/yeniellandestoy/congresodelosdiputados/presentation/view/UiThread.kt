package com.yeniellandestoy.congresodelosdiputados.presentation.view

import com.yeniellandestoy.congresodelosdiputados.domain.executor.PostExecutionThread
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by yeniel on 13/2/18.
 */
@Singleton
class UiThread
@Inject
constructor() : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}