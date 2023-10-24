package com.example.assignmenttwo.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignmenttwo.database.dao.CharacterDao
import com.example.assignmenttwo.R
import com.example.assignmenttwo.adapter.CharacterAdapter
import com.example.assignmenttwo.databinding.FragmentCharacterBinding
import com.example.assignmenttwo.decorator.AdaptiveSpacingItemDecoration
import com.example.assignmenttwo.di.factory.ViewModelFactory
import com.example.assignmenttwo.viewmodel.CharacterViewModel
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


class CharacterFragment @Inject constructor(
    private val factory: ViewModelFactory,
    private val gson: Gson,
    private val characterItemDao: CharacterDao,
    private val linearLayoutManager: LinearLayoutManager,
    private val characterAdapter: CharacterAdapter
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

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, factory)[CharacterViewModel::class.java]


        binding.rvCharacter.layoutManager = linearLayoutManager
        binding.rvCharacter.setHasFixedSize(true)
        binding.rvCharacter.adapter = characterAdapter
        binding.rvCharacter.addItemDecoration(AdaptiveSpacingItemDecoration(10))

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getAllCharacters().collect(FlowCollector {
                characterAdapter.submitData(it)
                characterAdapter.notifyDataSetChanged()
            })

        }
    }
}