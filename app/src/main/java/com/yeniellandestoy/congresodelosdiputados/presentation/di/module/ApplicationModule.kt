package com.yeniellandestoy.congresodelosdiputados.presentation.di.module

import android.content.Context
import com.yeniellandestoy.congresodelosdiputados.data.dto.VotacionDto
import com.yeniellandestoy.congresodelosdiputados.data.executor.JobExecutor
import com.yeniellandestoy.congresodelosdiputados.data.net.ApiClient
import com.yeniellandestoy.congresodelosdiputados.data.net.votacion.VotacionApiClient
import com.yeniellandestoy.congresodelosdiputados.data.repository.VotacionRepositoryImpl
import com.yeniellandestoy.congresodelosdiputados.domain.executor.PostExecutionThread
import com.yeniellandestoy.congresodelosdiputados.domain.executor.ThreadExecutor
import com.yeniellandestoy.congresodelosdiputados.domain.repository.VotacionRepository
import com.yeniellandestoy.congresodelosdiputados.presentation.view.CongresoDeLosDiputadosApplication
import com.yeniellandestoy.congresodelosdiputados.presentation.view.UiThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by yeniel on 10/2/18.
 */
@Module
class ApplicationModule(private val congresoDeLosDiputadosApplication: CongresoDeLosDiputadosApplication) {

    @Provides
    @Singleton
    fun application(): CongresoDeLosDiputadosApplication {
        return congresoDeLosDiputadosApplication
    }

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return congresoDeLosDiputadosApplication
    }

    @Provides
    @Singleton
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @Singleton
    fun provideVotacionRepository(votacionRepository: VotacionRepositoryImpl): VotacionRepository {
        return votacionRepository

    }

    @Provides
    @Singleton
    fun provideVotacionApiClient(votacionApiClient: VotacionApiClient): ApiClient<VotacionDto, String> {
        return votacionApiClient

    }
}