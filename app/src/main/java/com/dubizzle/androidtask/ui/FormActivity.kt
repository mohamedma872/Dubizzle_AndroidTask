package com.dubizzle.androidtask.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.dubizzle.androidtask.R
import com.dubizzle.androidtask.databinding.ActivityFormBinding

private lateinit var binding: ActivityFormBinding

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.let {
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeButtonEnabled(true)
            it.setTitle("Form")
        }

        binding.fab.setOnClickListener {
            findNavController(R.id.nav_host_fragment).navigate(R.id.settingsFragment)
        }

    }
}