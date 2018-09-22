package com.yeniellandestoy.congresodelosdiputados.domain.executor

import rx.Scheduler

/**
 * Created by yeniel on 13/2/18.
 */
interface PostExecutionThread {
    val scheduler: Scheduler
}