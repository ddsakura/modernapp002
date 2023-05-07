package com.example.recyclerviewtest.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.recyclerviewtest.models.Item

class DetailViewModel(state: SavedStateHandle)  : ViewModel() {

    // https://stackoverflow.com/questions/66238882/pass-arguments-from-fragment-to-viewmodel-function
    // https://developer.android.com/topic/libraries/architecture/viewmodel-savedstate
    private val item = state.get<Item>("param")

    private val _gitItem = MutableLiveData<Item>().apply {
        println("DetailViewModel: ${item?.name}")
        value = item
    }
    val gitItem: LiveData<Item> = _gitItem
}