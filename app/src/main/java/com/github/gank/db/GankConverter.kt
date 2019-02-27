package com.github.gank.db

import android.text.TextUtils
import androidx.room.TypeConverter
import androidx.room.util.StringUtil
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

/**
 * 项目名称：FlowChat
 * 类的描述：
 * 创建人员：hewking
 * 创建时间：2019/2/27 0027:11:42
 * 修改人员：hewking
 * 修改时间：2019/2/27 0027 11 42
 * 修改备注：
 * Version: 1.0.0
 */
class GankConverter {

    @TypeConverter
    fun fromImages(imgs : List<String>) : String {
        return TextUtils.join(",",imgs)
    }

    @TypeConverter
    fun toImgs(imgs : String) : List<String> {
        val splits = TextUtils.split(imgs,",")
        return splits.toList()
    }

}