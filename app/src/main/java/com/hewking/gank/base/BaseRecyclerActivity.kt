package com.hewking.gank.base

import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.hewking.gank.R
import kotlinx.android.synthetic.main.base_recycler_activity.*

/**
 * 项目名称：FlowChat
 * 类的描述：
 * 创建人员：hewking
 * 创建时间：2019/2/26 0026:14:05
 * 修改人员：hewking
 * 修改时间：2019/2/26 0026 14 05
 * 修改备注：
 * Version: 1.0.0
 */
abstract class BaseRecyclerActivity<T> : BaseActivity(){

    protected var mAdapter : CommonBaseAdapter<T>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_recycler_activity)

        setUpView()

    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    abstract fun loadData()

    protected open fun setUpView() {
        refreshlayout.setOnRefreshListener {
            refreshData()
        }
        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.itemAnimator = DefaultItemAnimator()
        mAdapter = buildAdapter()
        rv_list.adapter = mAdapter
    }

    abstract fun buildAdapter(): CommonBaseAdapter<T>

    protected open fun refreshData(){
        refreshlayout.isRefreshing = true
    }

    protected fun appendData(datas : List<T>){
        mAdapter?.appendData(datas)
    }

    protected open fun onLoadEnd(){
        refreshlayout.isRefreshing = false
    }

}