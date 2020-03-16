package com.inspirecoding.navcompdemo.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inspirecoding.navcompdemo.model.ToDo

class Fragment_3_ViewModel: ViewModel()
{
    private val __listOfToDos: MutableList<ToDo> = mutableListOf()
    private val _listOfToDos = MutableLiveData<MutableList<ToDo>>()
    val listOfTodos: LiveData<MutableList<ToDo>>
        get() = _listOfToDos

    fun addNewToDo(toDo: ToDo)
    {
        toDo.id = __listOfToDos.size
        __listOfToDos.add(toDo)
        _listOfToDos.value = __listOfToDos
    }
}