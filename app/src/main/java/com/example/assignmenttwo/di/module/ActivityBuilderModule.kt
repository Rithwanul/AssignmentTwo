package com.example.assignmenttwo.di.module

import com.example.assignmenttwo.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}