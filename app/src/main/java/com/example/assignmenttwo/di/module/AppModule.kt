package com.example.assignmenttwo.di.module

import dagger.Module


@Module(
    includes = [
        ViewModelModule::class,
        NetworkModule::class
    ]
)
class AppModule {
}