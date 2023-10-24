package com.example.assignmenttwo.di.module

import com.example.assignmenttwo.ui.activitiy.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(
        modules = [
            NavHostModule::class,
            AdapterModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}