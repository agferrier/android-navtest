package com.example.navtest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.navtest.R
import kotlinx.android.synthetic.main.fragment_layout.*

class FragmentA1: Fragment()  {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_label.text = this::class.java.simpleName
        go_button.setOnClickListener {
            activity?.findNavController(R.id.fragment_a_nav_controller)?.navigate(R.id.action_fragmentA1_to_fragmentA2)
        }

    }
}
