package com.gmail.avoishel.imageloader_hilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.net.URL
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: MyImageRepository
): ViewModel () {

    private val _imageUrlLiveData = MutableLiveData<String>()
    val imageUrlLiveData: LiveData<String> = _imageUrlLiveData

    fun fetchNewImageUrl(){
        val newImageUrl = repository.getRandomImageUrl()
        _imageUrlLiveData.postValue(newImageUrl)
    }

}