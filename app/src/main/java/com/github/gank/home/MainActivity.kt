package com.github.hgankio.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.gank.vm.GankDayViewModel
import com.github.hgankio.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vm = ViewModelProvider.NewInstanceFactory().create(GankDayViewModel::class.java)
        vm.data.observe(this, Observer<String> {
            tv_text.text = it
        })

    }

    fun onNext(data : String) {

    }
}
