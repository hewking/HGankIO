package com.hewking.gank.ui.home

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hewking.gank.R
import com.hewking.gank.base.BaseRecyclerActivity
import com.hewking.gank.base.CommonBaseAdapter
import com.hewking.gank.base.CommonViewHolder
import com.hewking.gank.data.entity.GirlEntity
import com.hewking.gank.util.ex.load
import com.hewking.gank.viewmodels.GirlsViewModel
import com.hewking.gank.viewmodels.GirlsViewModelFactory
import com.hewking.gank.widget.MultiImageLayout
import kotlin.random.Random

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
                return R.layout.girls_item
            }

            override fun onBindViewHolder(holder: CommonViewHolder<GirlEntity>, position: Int) {
                val girlEntity = mDatas[position]
                holder.v<TextView>(R.id.tv_author).text = "发布者: ${girlEntity.author}"
                holder.v<TextView>(R.id.tv_category).text = "分类: ${girlEntity.category}"
                holder.v<TextView>(R.id.tv_desc).text = "描述: ${girlEntity.desc}"
                holder.v<TextView>(R.id.tv_time).text = "时间: ${girlEntity.createdAt}"
//                holder.v<ImageView>(R.id.iv_girl).load(girlEntity.images[0])
                val multiImageLayout = holder.v<MultiImageLayout>(R.id.multyImage)
                multiImageLayout.adapter = object : MultiImageLayout.Adapter {
                    override fun displayImage(image: ImageView,icon:String) {
                        image.load(icon)
                        Log.d("displayImage",icon)
                    }
                }

                val imageCount = Random.nextInt(0,9)
                val imagesUrls = with(imageCount) {
                    val res = mutableListOf<String>()
                    for (i in 0 until imageCount) {
                       res.add(girlEntity.images[0])
                    }
                    res
                }

                multiImageLayout.imageUrls = imagesUrls

                holder.itemView.setOnLongClickListener {
                    val dialog = AlertDialog.Builder(this@MainActivity)
                            .setMessage("是否删除当前数据")
                            .setPositiveButton("确定") { d, v ->
                                val data = girlEntity
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
