package com.example.amazon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon.adapter.EssentialAdapter
import com.example.amazon.model.Essential

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var ll_fashion: LinearLayout
    lateinit var ll_popular: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        ll_fashion = findViewById(R.id.ll_fashion)
        ll_popular = findViewById(R.id.ll_fashion1)
        recyclerView = findViewById(R.id.rv_essential)
        val manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = manager

        refreshAdapter(getEssentials())

        setLinearHeight(ll_fashion)
        setLinearHeight(ll_popular)
    }

    fun setLinearHeight(layout: LinearLayout) {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        var heightPixels = displayMetrics.heightPixels

        val heightInDp: Int = heightPixels / resources.displayMetrics.density.toInt()

        val params: ViewGroup.LayoutParams = layout.layoutParams
        params.height = heightInDp
        layout.layoutParams = params
    }

    fun refreshAdapter(items: ArrayList<Essential>) {
        val adapter = EssentialAdapter(this, items)
        recyclerView.adapter = adapter
    }

    fun getEssentials(): ArrayList<Essential> {
        val items: ArrayList<Essential> = ArrayList()

        items.add(Essential("Oculus", R.drawable.cam_1))
        items.add(Essential("Oculus", R.drawable.cam_2))
        items.add(Essential("Oculus", R.drawable.cam_3))
        items.add(Essential("Oculus", R.drawable.cam_4))

        return items
    }
}