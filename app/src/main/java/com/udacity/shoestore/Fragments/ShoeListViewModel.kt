package com.udacity.shoestore.Fragments

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {

    private var _shoeList = mutableListOf<Shoe>()

    private var  _shoeData = MutableLiveData<List<Shoe>>()

    val shoeData :MutableLiveData<List<Shoe>>
        get() = _shoeData


    init {
        var temp = Shoe("sneaker", 5.0, "balenciaga", "knit", mutableListOf(""))

        _shoeList.add(temp)
        _shoeData.value = _shoeList

    }

    fun add(shoe :Shoe) {
        _shoeList.add(shoe)

        _shoeData.value = _shoeList
    }

}