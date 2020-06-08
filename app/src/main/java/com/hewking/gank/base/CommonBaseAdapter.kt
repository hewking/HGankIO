package com.hewking.gank.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.*

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

abstract class CommonBaseAdapter<T>(diffCallback: DiffUtil.ItemCallback<T>)
    : RecyclerView.Adapter<CommonViewHolder<T>>() {

    protected val mDiffer = AsyncListDiffer<T>(
            AdapterListUpdateCallback(this),
            AsyncDifferConfig.Builder(diffCallback).build()
    )

    private val mListener = AsyncListDiffer.ListListener<T> { previousList, currentList ->
        this.onCurrentListChanged(previousList,currentList)
    }

    init {
        mDiffer.addListListener(mListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder<T> {
        val layoutId = getItemLayoutId(viewType)
        if (layoutId == -1) {
            throw IllegalArgumentException("layoutId 无效")
        }
        val itemView = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return CommonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommonViewHolder<T>, position: Int) {
        holder.bind(position, getItem(position), getItemViewType(position))
    }

    override fun getItemCount(): Int {
        return mDiffer.currentList.size
    }

    open fun getCurrentList(): List<T>? {
        return mDiffer.currentList
    }

    open fun submitList(list: List<T>?) {
        mDiffer.submitList(list)
    }

    open fun submitList(list: List<T>?, commitCallback: Runnable?) {
        mDiffer.submitList(list, commitCallback)
    }

    protected open fun getItem(position: Int): T {
        return mDiffer.currentList[position]
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    protected abstract fun getItemLayoutId(viewType: Int): Int

    fun appendData(datas : List<T>){
        if (datas.isNotEmpty()) {
            val oldSize = mDiffer.currentList.size
            val count = datas.size - oldSize
            mDiffer.currentList.addAll(datas)
            notifyItemRangeInserted(oldSize,count)
        }
    }

    fun deleteItem(t: T) {
        val pos = mDiffer.currentList.indexOf(t)
        if (pos != -1) {
            mDiffer.currentList.removeAt(pos)
            notifyItemRemoved(pos)
        }
    }

    open fun onCurrentListChanged(previousList: List<T>, currentList: List<T>) {}

}