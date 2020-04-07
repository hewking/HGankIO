package com.hewking.gank.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * 项目名称：FlowChat
 * 类的描述：
 * 创建人员：hewking
 * 创建时间：2019/2/26 0026:14:13
 * 修改人员：hewking
 * 修改时间：2019/2/26 0026 14 13
 * 修改备注：
 * Version: 1.0.0
 */
abstract class CommonBaseAdapter<T> : RecyclerView.Adapter<CommonViewHolder<T>>(){

    protected var mDatas = mutableListOf<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder<T> {
        val layoutId = getItemLayoutId(viewType)
        if ( layoutId== -1) {
            throw IllegalArgumentException("layoutId 无效")
        }
        val itemView = LayoutInflater.from(parent.context).inflate(layoutId,parent,false)
        return CommonViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    override fun onBindViewHolder(holder: CommonViewHolder<T>, position: Int) {
        holder.bind(position,mDatas[position],getItemViewType(position))
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    fun appendData(datas : List<T>){
        if (datas.isNotEmpty()) {
            val oldSize = mDatas.size
            val count = datas.size
            mDatas.addAll(datas)
            notifyItemRangeInserted(oldSize,count)
        }
    }

    protected abstract fun getItemLayoutId(viewType : Int) : Int

    fun deleteItem(t: T) {
        val pos = mDatas.indexOf(t)
        if (pos != -1) {
            mDatas.removeAt(pos)
            notifyItemRemoved(pos)
        }
    }

}