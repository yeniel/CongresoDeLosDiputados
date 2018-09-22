package com.yeniellandestoy.congresodelosdiputados.presentation.di.component

import com.yeniellandestoy.congresodelosdiputados.presentation.di.module.ActivityModule
import com.yeniellandestoy.congresodelosdiputados.presentation.di.scope.PerActivity
import com.yeniellandestoy.congresodelosdiputados.presentation.view.activity.MainActivity
import dagger.Component

/**
 * Created by yeniel on 13/2/18.
 */
@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}