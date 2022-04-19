package com.gmail.avoishel.imageloader_hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.gmail.avoishel.imageloader_hilt.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var picasso: Picasso

    private val viewModel: MainActivityViewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            viewModel.fetchNewImageUrl()
        }

        viewModel.imageUrlLiveData.observe(this) { imageUrl ->

            picasso.load(imageUrl).into(binding.imageView)
        }
    }
}