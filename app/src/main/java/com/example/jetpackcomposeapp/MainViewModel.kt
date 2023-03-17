package com.example.jetpackcomposeapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.jetpackcomposeapp.model.Note
import com.example.jetpackcomposeapp.utils.TYPE_FIREBASE
import com.example.jetpackcomposeapp.utils.TYPE_ROOM

class MainViewModel(application: Application) :AndroidViewModel(application){

    val readRTest:MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>()
    }
    val dbType:MutableLiveData<String> by lazy {
        MutableLiveData<String>(TYPE_ROOM )
    }
    init {
        readRTest.value = when(dbType.value){
                TYPE_ROOM ->{
                    listOf<Note>(
                        Note(title = "Note1", subtitle = "subtitle1"),
                        Note(title = "Note2", subtitle = "subtitle2"),
                        Note(title = "Note3", subtitle = "subtitle3"),
                        Note(title = "Note4", subtitle = "subtitle4")
                    )
                }
                TYPE_FIREBASE -> listOf()
                else -> listOf()
            }
    }
    fun initDataBase(type:String){
        dbType.value = type
        Log.e("ololo", "initDataBase: $type" )
    }

}

class  MainViewModelFactory(private val application: Application  ):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(application = application) as T
        }
        throw IllegalArgumentException("errorViewModel")
    }

    }
