package com.gmail.avoishel.imageloader_hilt

import android.widget.ImageView
import com.squareup.picasso.Picasso
import javax.inject.Inject

class PicassoUtil @Inject constructor(
    private val picasso: Picasso
) {

    fun loadImage(imageUrl: String, imageView: ImageView){
        picasso.load(imageUrl).into(imageView)
    }
}