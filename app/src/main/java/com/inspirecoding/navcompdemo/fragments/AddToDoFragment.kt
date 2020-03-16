package com.inspirecoding.navcompdemo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.navGraphViewModels

import com.inspirecoding.navcompdemo.R
import com.inspirecoding.navcompdemo.model.ToDo
import com.inspirecoding.navcompdemo.utils.Prioirities
import kotlinx.android.synthetic.main.fragment_add_to_do.view.*

class AddToDoFragment : DialogFragment()
{
    private lateinit var rootView: View
    private val fragment3Viewmodel by navGraphViewModels<Fragment_3_ViewModel>(R.id.navigation_graph)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View?
    {
        rootView = inflater.inflate(R.layout.fragment_add_to_do, container, false)

        rootView.btn_addItem_ok.setOnClickListener {
            fragment3Viewmodel.addNewToDo(createToDo())
            dismiss()
        }

        rootView.btn_addItem_cancel.setOnClickListener {
            dismiss()
        }

        return rootView
    }

    private fun createToDo() = ToDo(
        0,
        rootView.et_addItem_title.text.toString(),
        rootView.et_addItem_description.text.toString(),
        if(rootView.rb_addItem_prio_low.isChecked)
        {
            Prioirities.LOW
        }
        else if (rootView.rb_addItem_prio_medium.isChecked)
        {
            Prioirities.MEDIUM
        }
        else
        {
            Prioirities.HIGH
        }
    )
}
