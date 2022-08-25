package com.dubizzle.androidtask.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dubizzle.androidtask.databinding.FragmentSettingsBinding
import com.dubizzle.presentation.factory.ViewModelFactory
import com.dubizzle.presentation.viewmodel.FormViewModel
import javax.inject.Inject


class SettingsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var formVM: FormViewModel

    private var _binding: FragmentSettingsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)

        // Change InQueue counter textView's text

/*        formVM.inQueueResource.observe(
            viewLifecycleOwner
        ) { resource ->
            when (resource.status) {
                Status.LOADING -> {
                    println("Loading")
                    tv_in_queue_count.text = "0"
                }
                Status.ERROR -> {
                    println("ERROR: ${resource.message}")
                    tv_in_queue_count.text = "0"
                }
                Status.SUCCESS -> {
                    resource.data?.let { count ->
                        tv_in_queue_count?.let {  it.text = count.toString() }
                    }
                }
            }
        }
        */

        /*
         * Sync Button OnClick Listener
         * Total successfully value changes with In Queue count value
         */
        return binding.root
    }

}