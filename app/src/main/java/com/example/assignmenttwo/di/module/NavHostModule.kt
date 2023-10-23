package com.example.assignmenttwo.di.module

import com.example.assignmenttwo.navigation.CustomNavHost
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NavHostModule {
    @ContributesAndroidInjector(
        modules = [
            FramentBindingModule::class
        ]
    )
    abstract fun contributeNavHost(): CustomNavHost
}