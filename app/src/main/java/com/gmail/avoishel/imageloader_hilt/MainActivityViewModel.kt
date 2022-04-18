package com.gmail.avoishel.imageloader_hilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.net.URL

class MainActivityViewModel: ViewModel() {

    private val repository = MyImageRepository()

    private val _imageUrlLiveData = MutableLiveData<String>()
    val imageUrlLiveData: LiveData<String> = _imageUrlLiveData

    fun fetchNewImageUrl(){
        val newImageUrl = repository.getRandomImageUrl()
        _imageUrlLiveData.postValue(newImageUrl)
    }

}