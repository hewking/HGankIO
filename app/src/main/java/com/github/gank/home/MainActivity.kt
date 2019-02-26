package com.github.gank.home

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.gank.base.BaseRecyclerActivity
import com.github.gank.base.CommonBaseAdapter
import com.github.gank.base.CommonViewHolder
import com.github.gank.bean.GankDayBean
import com.github.gank.vm.GankDayViewModel
import com.github.hgankio.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseRecyclerActivity<GankDayBean>() {

    private val vm = ViewModelProvider.NewInstanceFactory().create(GankDayViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm.init()


    }

    override fun loadData() {
        vm.data.observe(this, Observer<List<GankDayBean>> {
            mAdapter?.appendData(it)
        })
    }

    override fun buildAdapter(): CommonBaseAdapter<GankDayBean> {
        return object : CommonBaseAdapter<GankDayBean>(){
            override fun getItemLayoutId(viewType: Int): Int {
                return android.R.layout.simple_list_item_1
            }

            override fun onBindViewHolder(holder: CommonViewHolder<GankDayBean>, position: Int) {
                holder.v<TextView>(android.R.id.text1).text = mDatas[position].toString()
            }

        }
    }
}
