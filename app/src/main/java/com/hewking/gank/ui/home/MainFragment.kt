package com.hewking.gank.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import com.hewking.gank.R
import com.hewking.gank.base.BaseRecyclerFragment
import com.hewking.gank.base.CommonBaseAdapter
import com.hewking.gank.base.CommonViewHolder
import com.hewking.gank.data.entity.GirlEntity
import com.hewking.gank.ui.imageViewer.ImageViewerActivity
import com.hewking.gank.util.ex.load
import com.hewking.gank.viewmodels.GirlsViewModel
import com.hewking.gank.widget.MultiImageLayout

class MainFragment : BaseRecyclerFragment<GirlEntity>() {

    private val viewModel = ViewModelProvider.NewInstanceFactory().create(GirlsViewModel::class.java)

    private val diffItemCallback = object : DiffUtil.ItemCallback<GirlEntity>() {
        override fun areItemsTheSame(
                oldItem: GirlEntity,
                newItem: GirlEntity
        ): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(
                oldItem: GirlEntity,
                newItem: GirlEntity
        ): Boolean {
            return oldItem.title == newItem.title
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.girls.observe(viewLifecycleOwner, Observer {
            mAdapter?.submitList(it)
            onLoadEnd()
        })
    }


    override fun loadData() {
    }

    override fun refreshData() {
        super.refreshData()
        onLoadEnd()
    }

    private val mDisplayImageAdapter = object : MultiImageLayout.Adapter {
        override fun displayImage(image: ImageView, url: String) {
            image.load(url)
            image.also {
                it.setOnClickListener {
                    ImageViewerActivity.start(this@MainFragment.requireActivity(), url)
                }
            }
        }
    }

    override fun buildAdapter(): CommonBaseAdapter<GirlEntity> {
        return object : CommonBaseAdapter<GirlEntity>(diffItemCallback) {
            override fun getItemLayoutId(viewType: Int): Int {
                return R.layout.girls_item
            }

            override fun onBindViewHolder(holder: CommonViewHolder<GirlEntity>, position: Int) {
                val girlEntity = getItem(position)
                holder.v<TextView>(R.id.tv_author).text = getString(R.string.home_publish_text, girlEntity.author)
                holder.v<TextView>(R.id.tv_category).text = getString(R.string.home_category_text, girlEntity.category)
                holder.v<TextView>(R.id.tv_desc).text = girlEntity.desc
                val multiImageLayout = holder.v<MultiImageLayout>(R.id.multyImage)
                multiImageLayout.imageUrls = girlEntity.images
                multiImageLayout.adapter = mDisplayImageAdapter
                holder.itemView.setOnLongClickListener {
                    AlertDialog.Builder(this@MainFragment.requireActivity())
                            .setMessage("是否删除当前数据")
                            .setPositiveButton("确定") { d, _ ->
                                mAdapter?.deleteItem(girlEntity)
                                viewModel.deleteData(girlEntity)
                                d.dismiss()
                            }
                            .setNegativeButton("取消") { d, _ ->
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
