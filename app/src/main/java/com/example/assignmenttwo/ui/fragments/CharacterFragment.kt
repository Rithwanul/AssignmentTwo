package com.example.assignmenttwo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.assignmenttwo.CharacterItemDao
import com.example.assignmenttwo.R
import com.example.assignmenttwo.databinding.FragmentCharacterBinding
import com.example.assignmenttwo.di.factory.ViewModelFactory
import com.example.assignmenttwo.model.entity.CharacterItem
import com.example.assignmenttwo.viewmodel.CharacterViewModel
import com.google.gson.Gson
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


class CharacterFragment @Inject constructor(
    private val factory: ViewModelFactory,
    private val gson: Gson,
    private val characterItemDao: CharacterItemDao
) : Fragment() {

    private lateinit var viewModel: CharacterViewModel
    private lateinit var binding: FragmentCharacterBinding
    val actors = StringBuilder()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_character, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, factory)[CharacterViewModel::class.java]


        val characterItem = CharacterItem(
            id = "02",
            image = "image",
            ancestry = "Ok",
            actor = "Jeen",
            house = "Horror",
            name = "Hello"
        )


        lifecycleScope.launch {
            viewModel.getAllCharacter().collect(FlowCollector { it ->
                it.forEach { item ->
                    Timber.tag("Data").v(item.name)
                }
            })
        }

        lifecycleScope.launch {
            characterItemDao.insertCharacterItem(characterItem)
        }
    }
}