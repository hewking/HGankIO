package com.hewking.gank.ui.imageViewer

import android.app.Activity
import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.hewking.gank.base.BaseActivity
import com.hewking.gank.databinding.ActivityImageViewerBinding
import com.hewking.gank.util.ex.load

class ImageViewerActivity : BaseActivity(){

    companion object {

        private const val IMAGE_URL = "image_url"

        fun start(activity: Activity,url:String){
            Intent(activity,ImageViewerActivity::class.java).also {
                it.putExtra(IMAGE_URL,url)
                activity.startActivity(it)
            }
        }
    }

    private lateinit var binding: ActivityImageViewerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageViewerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.initView()
    }

    private fun initView(){
        val imageUrl = intent.getStringExtra(IMAGE_URL)
        binding.ivViewer.load(imageUrl?:"")
    }

}