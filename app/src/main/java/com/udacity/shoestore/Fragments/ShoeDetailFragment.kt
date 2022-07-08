package com.udacity.shoestore.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    lateinit var binding :FragmentShoeDetailBinding

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        binding.btnCancel.setOnClickListener{
            findNavController().navigateUp()
        }

        binding.btnSave.setOnClickListener {
            if (binding.etInputName.text.isNotEmpty() && binding.etInputSize.text.isNotEmpty() &&
                binding.etInputCompany.text.isNotEmpty() && binding.etInputDescription.text.isNotEmpty()) {


                val shoe = Shoe(binding.etInputName.text.toString(), binding.etInputSize.text.toString().toDouble(),
                                binding.etInputCompany.text.toString(), binding.etInputDescription.text.toString(), listOf("1"))

                viewModel.add(shoe)

                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
            }
        }

        return binding.root
    }
}