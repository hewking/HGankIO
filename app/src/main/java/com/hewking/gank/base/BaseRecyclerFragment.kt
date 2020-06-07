package com.hewking.gank.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.hewking.gank.R
import com.hewking.gank.databinding.BaseRecyclerActivityBinding
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
abstract class BaseRecyclerFragment<T> : Fragment(){

    protected var mAdapter : CommonBaseAdapter<T>? = null

    private lateinit var binding : BaseRecyclerActivityBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = BaseRecyclerActivityBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setUpView()
        loadData()
    }

    override fun onResume() {
        super.onResume()
    }

    abstract fun loadData()

    protected open fun setUpView() {
        refreshlayout.setOnRefreshListener {
            refreshData()
        }
        rv_list.layoutManager = LinearLayoutManager(activity)
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

    protected open fun onRefreshEnd(){
        refreshlayout.isRefreshing = false
    }

}