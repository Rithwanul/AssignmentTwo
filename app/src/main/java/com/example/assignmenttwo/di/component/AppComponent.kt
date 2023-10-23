package com.example.assignmenttwo.di.component

import android.content.Context
import com.example.assignmenttwo.base.BaseApplication
import com.example.assignmenttwo.di.module.ActivityBuilderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuilderModule::class
])
interface AppComponent: AndroidInjector<BaseApplication> {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): AppComponent
    }
}