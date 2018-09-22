package com.yeniellandestoy.congresodelosdiputados.presentation.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yeniellandestoy.congresodelosdiputados.R
import com.yeniellandestoy.congresodelosdiputados.domain.model.Votacion
import com.yeniellandestoy.congresodelosdiputados.domain.usecase.GetVotacionesUseCase
import com.yeniellandestoy.congresodelosdiputados.presentation.di.component.ActivityComponent
import com.yeniellandestoy.congresodelosdiputados.presentation.di.component.DaggerActivityComponent
import com.yeniellandestoy.congresodelosdiputados.presentation.di.module.ActivityModule
import com.yeniellandestoy.congresodelosdiputados.presentation.view.CongresoDeLosDiputadosApplication
import rx.Subscriber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val component: ActivityComponent
        get() = DaggerActivityComponent.builder()
                .applicationComponent((application as CongresoDeLosDiputadosApplication).applicationComponent)
                .activityModule(ActivityModule(this))
                .build()

    @Inject
    lateinit var votacionesUseCase: GetVotacionesUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val votacionesSubscriber = object: Subscriber<List<Votacion>>() {
            override fun onNext(s: List<Votacion>) {
                for (votacion: Votacion in s) {
                    println(votacion.numeroVotacion)
                }
            }

            override fun onCompleted() {
                println("onComplete")
            }

            override fun onError(e: Throwable) {
                println("onError")
            }

        }

        votacionesUseCase.execute()

    }

}
