package com.dubizzle.androidtask.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dubizzle.androidtask.R
import com.dubizzle.androidtask.databinding.ActivityHomeBinding
import com.dubizzle.presentation.factory.ViewModelFactory
import com.dubizzle.presentation.model.Listings
import com.dubizzle.presentation.model.Status
import com.dubizzle.presentation.viewmodel.HomeViewModel
import com.google.gson.Gson
import dagger.android.AndroidInjection
import javax.inject.Inject

class HomeActivity : AppCompatActivity(),
    ListingsAdapter.Interaction {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var homeVM: HomeViewModel

    private val listingsAdapter = ListingsAdapter()

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.let {
            it.setDisplayShowHomeEnabled(false)
            it.setDisplayHomeAsUpEnabled(false)
            it.setHomeButtonEnabled(false)
            it.setTitle(R.string.ActivityHome)
        }
        initAdapter()
        homeVM = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        homeVM.listingsResource.observe(this, Observer {
            when (it.status) {
                Status.LOADING -> {
                    println("Loading")
                    showLoader()
                }
                Status.ERROR -> {
                    println("ERROR: ${it.message}")
                    hideLoader()
                }
                Status.SUCCESS -> {
                    hideLoader()
                    it.data?.let { Listings ->
                        listingsAdapter.swapData(Listings)
                        supportActionBar?.let { actionBar ->
                            actionBar.title = "Listings (${Listings.size})"
                        }
                    }
                }
            }
        })
    }

    /**
     * initialize the adapter
     * set the adapter to the recycle view
     */
    private fun initAdapter() {
        with(binding)
        {
            recyclerView.layoutManager = LinearLayoutManager(this@HomeActivity)
            listingsAdapter.interaction = this@HomeActivity
            recyclerView.adapter = listingsAdapter
        }
    }

    override fun listingsClicked(Object: Listings) {
        startActivity(
            Intent(this, DetailActivity::class.java).putExtra(
                "Listings",
                Gson().toJson(Object)
            )
        )
    }

    /**
     * Shows loading indicator
     */
    private fun showLoader() {
        with(binding)
        {
            progress.visibility = View.VISIBLE
            recyclerView.alpha = ALPHA_HIDDEN
        }
    }

    /**
     * Hides loading indicator
     */
    private fun hideLoader() {
        with(binding)
        {
            progress.visibility = View.GONE
            recyclerView.alpha = ALPHA_VISIBLE
        }
    }

    companion object {
        const val ALPHA_HIDDEN = 0.2f
        const val ALPHA_VISIBLE = 1.0f
    }
}