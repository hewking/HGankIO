package com.hewking.gank.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.children
import com.hewking.gank.R
import kotlin.math.ceil
import kotlin.math.floor

class MultiImageLayout(val ctx: Context, attrs: AttributeSet) : ViewGroup(ctx, attrs) {

    private var dividerPadding: Float
    var imageUrls: MutableList<String>? = null
        set(value) {
            field = value
            initAllImageView()
        }

    var adapter: Adapter? = null
        set(value) {
            field = value
            requestLayout()
        }

    init {
        val styledAttrs = ctx.obtainStyledAttributes(attrs, R.styleable.MultiImageLayout)
        dividerPadding = styledAttrs.getDimension(R.styleable.MultiImageLayout_dividerPadding, 3f)
        styledAttrs.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val wMode = MeasureSpec.getMode(widthMeasureSpec)
        val wSize = MeasureSpec.getSize(widthMeasureSpec)
        var hSize = MeasureSpec.getSize(heightMeasureSpec)
        val imageCount = childCount
        val rows = when (imageCount) {
            4 -> 2
            else -> {
                3
            }
        }
        if (wMode == MeasureSpec.EXACTLY && childCount > 0) {
            if (imageCount > 0) {
                hSize = if (imageCount > 1) {
                    val imageWidth = (wSize - 2 * dividerPadding).div(3).toInt()
                    children.forEach {
                        val imageSpec = MeasureSpec.makeMeasureSpec(imageWidth, MeasureSpec.EXACTLY)
                        it.measure(imageSpec, imageSpec)
                    }
                    ceil(imageCount.div(rows.toDouble())).toInt() * imageWidth
                } else {
                    getChildAt(0).measure(MeasureSpec.makeMeasureSpec(wSize,MeasureSpec.AT_MOST)
                            , MeasureSpec.makeMeasureSpec(wSize,MeasureSpec.AT_MOST))
                    wSize
                }
            }
        }

        setMeasuredDimension(wSize, hSize)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val imageCount = childCount
        if (imageCount > 1) {
            val child = getChildAt(0)
            val childWidth = child.measuredWidth
            // 1. 3 个以下显示一行，宽度childWidth
            // 2. 四个显示两行，正方形排列
            // 3. 5,6个显示两行
            // 4. 7-9个显示三行
            val rows = when (imageCount) {
                4 -> 2
                else -> {
                    3
                }
            }

            for (childIndex in 0 until childCount) {
                val i = childIndex.rem(rows)
                val j = floor(childIndex.div(rows.toDouble())).toInt()
                getChildAt(childIndex).layout(dividerPadding.toInt() + i * childWidth
                        , j * childWidth + dividerPadding.toInt(),
                        childWidth * (i + 1)
                        , childWidth * (j + 1))
                adapter?.displayImage(getChildAt(childIndex) as ImageView, imageUrls?.get(childIndex)
                        ?: "")
            }

        } else if (imageCount > 0) {
            val childIndex = 0
            val imageChild = getChildAt(childIndex)
            imageChild.layout(dividerPadding.toInt(), dividerPadding.toInt(),
                    imageChild.measuredWidth + dividerPadding.toInt(), imageChild.measuredHeight + dividerPadding.toInt())
            adapter?.displayImage(getChildAt(childIndex) as ImageView, imageUrls?.get(childIndex)
                    ?: "")
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
    }

    private fun initAllImageView() {
        removeAllViews()
        imageUrls?.let {
            it.forEach { _ ->
                val iv = ImageView(ctx).apply {
                    scaleType = ImageView.ScaleType.CENTER_CROP
                }
                addView(iv)
            }
        }
    }

    interface Adapter {
        fun displayImage(image: ImageView, url: String)
    }

}