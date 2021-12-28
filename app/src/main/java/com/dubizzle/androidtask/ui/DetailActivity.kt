package com.dubizzle.androidtask.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dubizzle.androidtask.R
import com.dubizzle.androidtask.databinding.ActivityDetailsBinding
import com.dubizzle.presentation.model.Listings
import com.google.gson.Gson
import dagger.android.AndroidInjection


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.let {
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeButtonEnabled(true)
            it.setTitle(R.string.ActivityDetail)
        }
        setData()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * INTENT DATA FROM MAIN CLASS
     * SETTING THE DATA TO THE DESIRED FIELDS
     */
    private fun setData() {
        intent.getStringExtra("Listings")?.run {
            val obj = Gson().fromJson(this, Listings::class.java)
            (getString(R.string.create_at) + obj?.createdAt).also {
                binding.createAt.text = it
            }
            (getString(R.string.price) + obj?.price).also { binding.price.text = it }
            (getString(R.string.name) + obj?.name).also { binding.name.text = it }
            (getString(R.string.uid) + obj?.uid).also { binding.uid.text = it }
            (getString(R.string.id) + obj?.imageIds?.get(0)).also { binding.id.text = it }
            val media = obj.imageUrls?.get(0)
            if (media !== null) {
                Glide.with(this@DetailActivity)
                    .load(media)
                    .into(binding.image)
            } else {
                binding.image.setImageResource(R.drawable.ic_launcher_background)
            }
        }
    }
}