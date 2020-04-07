package com.github.gank.home

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.crashlytics.android.Crashlytics
import com.github.gank.base.BaseRecyclerActivity
import com.github.gank.base.CommonBaseAdapter
import com.github.gank.base.CommonViewHolder
import com.github.gank.bean.GankDayBean
import com.github.gank.vm.GankDayViewModel
import com.github.hgankio.R
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseRecyclerActivity<GankDayBean>() {

    private val vm = ViewModelProvider.NewInstanceFactory().create(GankDayViewModel::class.java)
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.init()
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
    }

    override fun loadData() {
        vm.data.observe(this, Observer<List<GankDayBean>> {
            mAdapter?.appendData(it)
            onLoadEnd()
        })
    }

    override fun refreshData() {
        super.refreshData()
        vm.refresh()
    }

    override fun buildAdapter(): CommonBaseAdapter<GankDayBean> {
        return object : CommonBaseAdapter<GankDayBean>(){
            override fun getItemLayoutId(viewType: Int): Int {
                return android.R.layout.simple_list_item_1
            }

            override fun onBindViewHolder(holder: CommonViewHolder<GankDayBean>, position: Int) {
                holder.v<TextView>(android.R.id.text1).text = mDatas[position].toString()

                holder.itemView.setOnLongClickListener {
                    val dialog = AlertDialog.Builder(this@MainActivity)
                            .setMessage("是否删除当前数据")
                            .setPositiveButton("确定") { d, v ->
                                mAdapter?.deleteItem(mDatas[position])
                                vm.deleteData(mDatas[position])
                                Crashlytics.log("bug bug bug")
                                Crashlytics.getInstance().crash()
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
