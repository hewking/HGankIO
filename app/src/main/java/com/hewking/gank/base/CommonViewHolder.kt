package com.hewking.gank.base

import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

/**
 * 项目名称：FlowChat
 * 类的描述：
 * 创建人员：hewking
 * 创建时间：2019/2/26 0026:14:20
 * 修改人员：hewking
 * 修改时间：2019/2/26 0026 14 20
 * 修改备注：
 * Version: 1.0.0
 */
open class CommonViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(pos: Int, data: T, type: Int) {

    }

    fun <R : View> v(@IdRes resId: Int): R {
        return itemView.findViewById(resId)
    }

}