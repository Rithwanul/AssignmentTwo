package com.example.assignmenttwo.di.module

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.assignmenttwo.di.factory.CustomFragmentFactory
import com.example.assignmenttwo.di.key.FragmentKey
import com.example.assignmenttwo.ui.fragments.CharacterFragment
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FramentBindingModule {

    @Binds
    @IntoMap
    @FragmentKey(CharacterFragment::class)
    abstract fun bindCharacterFragment(characterFragment: CharacterFragment): Fragment

    @Binds
    abstract fun bindFragmentFactory(factory: CustomFragmentFactory) : FragmentFactory
}