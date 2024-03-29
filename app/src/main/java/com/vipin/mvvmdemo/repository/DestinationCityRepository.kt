package com.vipin.mvvmdemo.repository

import android.arch.lifecycle.MutableLiveData
import com.vipin.mvvmdemo.model.Destination

/**
 * Created by vipin.c on 07/07/2019
 */
class DestinationCityRepository {

    companion object {

        private var instance: DestinationCityRepository? = null
        private lateinit var mCityList: MutableList<Destination>
        private lateinit var newList: MutableLiveData<List<Destination>>

        fun getInstance(): DestinationCityRepository? {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = DestinationCityRepository()
                    }
                }
            }
            return instance
        }
    }

    fun getDataList(): MutableLiveData<List<Destination>>? {
        setDataList()
        newList = MutableLiveData()
        newList.value = mCityList

        return newList
    }

    private fun setDataList() {
        mCityList = mutableListOf(
            Destination(
                "https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                "Havasu Falls"
            ), Destination(
                "https://i.redd.it/tpsnoz5bzo501.jpg",
                "Trondheim"
            ),
            Destination(
                "https://i.redd.it/qn7f9oqu7o501.jpg",
                "Portugal"
            ),
            Destination(
                "https://i.redd.it/j6myfqglup501.jpg",
                "Rocky Mountain National Park"
            ),
            Destination(
                "https://i.redd.it/0h2gm1ix6p501.jpg",
                "Havasu Falls"
            ),
            Destination(
                "https://i.redd.it/k98uzl68eh501.jpg",
                "Mahahual"
            ),
            Destination(
                "https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                "Frozen Lake"
            ),
            Destination(
                "https://i.redd.it/obx4zydshg601.jpg",
                "Austrailia"
            )
        )
    }
}