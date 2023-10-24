package com.example.assignmenttwo.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.assignmenttwo.R
import com.example.assignmenttwo.databinding.FragmentCharacterDetailsBinding

class CharacterDetailsFragment : Fragment() {


    private lateinit var binding: FragmentCharacterDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_character_details, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val string = arguments?.getString("data")
        binding.name.text = string
    }
}