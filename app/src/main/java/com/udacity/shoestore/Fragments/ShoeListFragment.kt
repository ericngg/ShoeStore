package com.udacity.shoestore.Fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import kotlinx.android.synthetic.main.shoe_detail.view.*
import timber.log.Timber

class ShoeListFragment : Fragment() {

    lateinit var binding :FragmentShoeListBinding

    private val viewModel : ShoeListViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        // viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        viewModel.shoeData.observe(viewLifecycleOwner, Observer { shoeList ->
            shoeList.forEach { shoe ->

                val textView = View.inflate(context, R.layout.shoe_detail, null)
                textView.tvShoe.text = "${shoe.name}, ${shoe.size}, ${shoe.company}, ${shoe.description}"

                binding.linearLayout.addView(textView)
            }
        })

        binding.fabAdd.setOnClickListener{
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
        return true
    }
}