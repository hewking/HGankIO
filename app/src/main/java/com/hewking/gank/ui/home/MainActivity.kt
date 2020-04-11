package com.hewking.gank.ui.home

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hewking.gank.base.BaseRecyclerActivity
import com.hewking.gank.base.CommonBaseAdapter
import com.hewking.gank.base.CommonViewHolder
import com.hewking.gank.data.entity.GirlEntity
import com.hewking.gank.viewmodels.GirlsViewModel
import com.hewking.gank.viewmodels.GirlsViewModelFactory

class MainActivity : BaseRecyclerActivity<GirlEntity>() {

//    private val viewModel = ViewModelProvider.NewInstanceFactory().create(GirlsViewModel::class.java)

    private val viewModel  by viewModels<GirlsViewModel> {
        GirlsViewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.init()
    }

    override fun loadData() {
        viewModel.data.observe(this, Observer<List<GirlEntity>> {
            mAdapter?.appendData(it)
            onLoadEnd()
        })
    }

    override fun refreshData() {
        super.refreshData()
        viewModel.refresh()
    }

    override fun buildAdapter(): CommonBaseAdapter<GirlEntity> {
        return object : CommonBaseAdapter<GirlEntity>(){
            override fun getItemLayoutId(viewType: Int): Int {
                return android.R.layout.simple_list_item_1
            }

            override fun onBindViewHolder(holder: CommonViewHolder<GirlEntity>, position: Int) {
                holder.v<TextView>(android.R.id.text1).text = mDatas[position].desc

                holder.itemView.setOnLongClickListener {
                    val dialog = AlertDialog.Builder(this@MainActivity)
                            .setMessage("是否删除当前数据")
                            .setPositiveButton("确定") { d, v ->
                                val data = mDatas[position]
                                mAdapter?.deleteItem(data)
                                viewModel.deleteData(data)
                                d.dismiss()
                            }
                            .setNegativeButton("取消") { d, v ->
                                d.dismiss()
                            }
                            .create()
                            .show()
                    true
                }
            }

        }
    }
}
