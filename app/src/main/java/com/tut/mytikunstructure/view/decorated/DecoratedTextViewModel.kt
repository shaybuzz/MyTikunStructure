package com.tut.mytikunstructure.view.decorated

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DecoratedTextViewModel(application: Application) :AndroidViewModel(application) {

    private val _stringData = MutableLiveData<String>()
    private val stringData: LiveData<String> = _stringData

    
}