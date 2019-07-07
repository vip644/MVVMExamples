package com.vipin.mvvmdemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.vipin.mvvmdemo.R
import com.vipin.mvvmdemo.model.Destination

/**
 * Created by vipin.c on 07/07/2019
 */
class RecyclerAdapter(): RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>() {

    lateinit var mList: List<Destination>
    lateinit var mContext: Context

    constructor(mList: List<Destination>, mContext: Context) : this() {
        this.mList = mList
        this.mContext = mContext
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int):  ItemViewHolder{
        return ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item_view, p0, false));
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(p0: ItemViewHolder, p1: Int) {
        p0.cityName.text = mList[p1].title
        Glide.with(mContext)
            .load(mList[p1].imageUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(p0.imageView)
    }


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.city_image)!!
        val cityName = itemView.findViewById<TextView>(R.id.city_name)!!
    }
}