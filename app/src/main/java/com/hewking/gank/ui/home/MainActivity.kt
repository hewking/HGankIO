package com.hewking.gank.ui.home

import android.os.Bundle
import com.hewking.gank.base.BaseActivity
import com.hewking.gank.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (actionBar == null) {
            setSupportActionBar(binding.toolbar)
        }
    }
}
