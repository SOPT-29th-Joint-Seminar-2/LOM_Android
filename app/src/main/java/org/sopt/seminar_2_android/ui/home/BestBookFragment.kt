package org.sopt.seminar_2_android.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.seminar_2_android.R
import org.sopt.seminar_2_android.databinding.FragmentBestBookBinding
import org.sopt.seminar_2_android.ui.home.adapter.BookRecyclerAdapter


class BestBookFragment : Fragment() {

    private lateinit var binding: FragmentBestBookBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentBestBookBinding.inflate(layoutInflater)

        // Inflate the layout for this fragment
        return binding.root
    }

}