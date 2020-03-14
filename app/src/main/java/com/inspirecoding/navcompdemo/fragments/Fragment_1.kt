package com.inspirecoding.navcompdemo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.inspirecoding.navcompdemo.R
import kotlinx.android.synthetic.main.fragment_1.*

class Fragment_1 : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        btn_fragment_1.setOnClickListener {
            val navController: NavController = Navigation.findNavController(it)
            val action = Fragment_1Directions.actionFragment1ToFragment2()
            navController.navigate(action)
        }
    }
}
