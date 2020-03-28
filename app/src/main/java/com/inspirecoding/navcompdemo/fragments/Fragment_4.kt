package com.inspirecoding.navcompdemo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.inspirecoding.navcompdemo.R
import kotlinx.android.synthetic.main.fragment_4.*

class Fragment_4 : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_4, container, false)
    }

    // 1
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        // 2
        btn_fragment_4.setOnClickListener {
            // 3
            findNavController().navigate(R.id.action_fragment_4_to_fragment_5)
        }
    }
}
