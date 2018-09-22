package com.yeniellandestoy.congresodelosdiputados.presentation.di.module

import android.app.Activity
import com.yeniellandestoy.congresodelosdiputados.presentation.di.scope.PerActivity
import dagger.Module
import dagger.Provides

/**
 * Created by yeniel on 13/2/18.
 */
@Module
class ActivityModule(private val baseActivity: Activity) {

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    internal fun provideActivity(): Activity {
        return this.baseActivity
    }

}