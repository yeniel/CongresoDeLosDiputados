package com.yeniellandestoy.congresodelosdiputados.presentation.view

import android.app.Application
import com.yeniellandestoy.congresodelosdiputados.data.repository.VotacionRepositoryImpl
import com.yeniellandestoy.congresodelosdiputados.domain.executor.PostExecutionThread
import com.yeniellandestoy.congresodelosdiputados.domain.executor.ThreadExecutor
import com.yeniellandestoy.congresodelosdiputados.domain.model.Votacion
import com.yeniellandestoy.congresodelosdiputados.presentation.di.component.ApplicationComponent
import com.yeniellandestoy.congresodelosdiputados.presentation.di.component.DaggerApplicationComponent
import com.yeniellandestoy.congresodelosdiputados.presentation.di.module.ApplicationModule
import rx.Subscriber
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by yeniel on 10/2/18.
 */
class CongresoDeLosDiputadosApplication: Application() {

    val applicationComponent: ApplicationComponent
        get() = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()

    @Inject
    lateinit var votacionRepository: VotacionRepositoryImpl

    @Inject
    lateinit var threadExecutor: ThreadExecutor

    @Inject
    lateinit var postExecutionThread: PostExecutionThread

    override fun onCreate() {
        super.onCreate()

        applicationComponent.inject(this)

    }

}