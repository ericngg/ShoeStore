package com.udacity.shoestore.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.udacity.shoestore.R

class InstructionFragment : Fragment() {

    lateinit var btnNext : Button

    // lateinit var binding :InstructionFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        btnNext = view?.findViewById(R.id.btnNext)!!

        btnNext.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_instructionFragment_to_shoeListFragment))

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_instruction, container, false)
    }
}