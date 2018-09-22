package com.yeniellandestoy.congresodelosdiputados.presentation.di.component

import android.content.Context
import com.yeniellandestoy.congresodelosdiputados.data.dto.VotacionDto
import com.yeniellandestoy.congresodelosdiputados.data.net.ApiClient
import com.yeniellandestoy.congresodelosdiputados.domain.executor.PostExecutionThread
import com.yeniellandestoy.congresodelosdiputados.domain.executor.ThreadExecutor
import com.yeniellandestoy.congresodelosdiputados.domain.repository.VotacionRepository
import com.yeniellandestoy.congresodelosdiputados.presentation.di.module.ApplicationModule
import com.yeniellandestoy.congresodelosdiputados.presentation.navigation.Navigator
import com.yeniellandestoy.congresodelosdiputados.presentation.view.CongresoDeLosDiputadosApplication
import dagger.Component
import javax.inject.Singleton

/**
 * Created by yeniel on 10/2/18.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(congresoDeLosDiputadosApplication: CongresoDeLosDiputadosApplication)

    val congresoDeLosDiputadosApplication: CongresoDeLosDiputadosApplication

    fun context(): Context

    fun navigator(): Navigator

    fun threadExecutor(): ThreadExecutor

    fun postExecutionThread(): PostExecutionThread

    fun votacionRepository(): VotacionRepository

    fun votacionApiClient(): ApiClient<VotacionDto, String>
}