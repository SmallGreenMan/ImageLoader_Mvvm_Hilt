package com.gmail.avoishel.imageloader_hilt

class MyImageRepository {

    private val service = MyImageUrlService()

    fun getRandomImageUrl(): String{
        return service.getImageUrl()
    }
}