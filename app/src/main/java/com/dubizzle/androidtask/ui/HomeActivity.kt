package com.dubizzle.androidtask.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
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


    private lateinit var listingsAdapter : ListingsAdapter

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
        homeVM = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]

        homeVM.listingsResource.observe(this, {
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
    // inflating menu options
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.home_menu, menu)
        return true
    }

    // Handle item selection
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_api_form -> {
                startActivity(
                    Intent(this, FormActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * initialize the adapter
     * set the adapter to the recycle view
     */
    private fun initAdapter() {
        with(binding)
        {
            listingsAdapter = ListingsAdapter()
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