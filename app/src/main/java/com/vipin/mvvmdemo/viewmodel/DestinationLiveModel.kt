package com.vipin.mvvmdemo.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.vipin.mvvmdemo.model.Destination
import com.vipin.mvvmdemo.repository.DestinationCityRepository

/**
 * Created by vipin.c on 07/07/2019
 */
class DestinationLiveModel: ViewModel() {

    private lateinit var mDestinationList : MutableLiveData<List<Destination>>
    private lateinit var mDestinationCityRepository: DestinationCityRepository

    fun initialize(){
        mDestinationCityRepository = DestinationCityRepository.getInstance()!!
        mDestinationList = mDestinationCityRepository.getDataList()!!
    }

    fun getAllDestination() : LiveData<List<Destination>>{
        return mDestinationList
    }
}