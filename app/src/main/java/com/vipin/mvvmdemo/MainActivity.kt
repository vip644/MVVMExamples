package com.vipin.mvvmdemo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.vipin.mvvmdemo.adapter.RecyclerAdapter
import com.vipin.mvvmdemo.viewmodel.DestinationLiveModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mDestinationLiveModel : DestinationLiveModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mRecyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab.setOnClickListener(this)
        mRecyclerView = findViewById(R.id.recycler_view)

        mDestinationLiveModel = ViewModelProviders.of(this).get(DestinationLiveModel::class.java)
        mDestinationLiveModel.initialize()
        mDestinationLiveModel.getAllDestination().observe(this, Observer {
            mRecyclerAdapter.notifyDataSetChanged()
        })

        mRecyclerAdapter = RecyclerAdapter(mDestinationLiveModel.getAllDestination().value!!, this)
        mRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRecyclerView.adapter = mRecyclerAdapter
    }

    override fun onClick(v: View?) {

    }
}
