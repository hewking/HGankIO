package com.hewking.gank.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.hewking.gank.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setupView()
    }

    private fun setupView() {
        val titles = arrayOf("主页","推荐","妹子","今日","Android")
        binding.viewPager.adapter = HomeAdapter(this)
        TabLayoutMediator(binding.tablayout, binding.viewPager) { tab, pos ->
            tab.text = titles[pos]
        }.attach()
    }

    class HomeAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int {
            return 5
        }

        override fun createFragment(position: Int): Fragment {
            val fragment = MainFragment()
            fragment.arguments = Bundle().apply {

            }
            return fragment
        }

    }
}

