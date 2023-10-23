package com.example.assignmenttwo.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.assignmenttwo.R
import com.example.assignmenttwo.databinding.FragmentCharacterBinding
import com.example.assignmenttwo.di.factory.ViewModelFactory
import com.example.assignmenttwo.viewmodel.CharacterViewModel
import javax.inject.Inject


class CharacterFragment @Inject constructor(
    private val factory: ViewModelFactory
) : Fragment() {

    private lateinit var viewModel: CharacterViewModel
    private lateinit var binding: FragmentCharacterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_character, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, factory)[CharacterViewModel::class.java]

        binding.name.text = viewModel.getName().toString()

    }
}