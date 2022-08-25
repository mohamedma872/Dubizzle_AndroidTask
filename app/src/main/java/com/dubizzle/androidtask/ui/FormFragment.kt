package com.dubizzle.androidtask.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dubizzle.androidtask.databinding.FragmentFormBinding
import com.dubizzle.presentation.factory.ViewModelFactory
import com.dubizzle.presentation.viewmodel.FormViewModel
import javax.inject.Inject

class FormFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var formVM: FormViewModel

    private var _binding: FragmentFormBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        _binding = FragmentFormBinding.inflate(inflater, container, false)

//        formVM = ViewModelProvider(this, viewModelFactory)[FormViewModel::class.java]

/*
        btn_submit.setOnClickListener {
            val mediaTypeText = et_media_type.text.toString()
            val timeWindowText = et_time_window.text.toString()
            if (mediaTypeText != "" && timeWindowText != "") {}
                 TODO IF Body

        }
*/
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

