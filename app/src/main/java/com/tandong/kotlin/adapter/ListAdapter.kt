package com.tandong.kotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tandong.kotlin.R


/**
 * Created by office on 2018/1/17.
 */
class ListAdapter(private val mContext: Context, private val mDatas: List<String>) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var inflater: LayoutInflater? = null

    override fun getItemCount(): Int {
        return mDatas!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv.text = mDatas!![position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        inflater = LayoutInflater.from(mContext)
        val view = inflater!!.inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view)
    }

    class MyViewHolder(view: View) : ViewHolder(view) {
        var tv: TextView

        init {
            tv = view.findViewById(R.id.tv_text)
        }
    }
}