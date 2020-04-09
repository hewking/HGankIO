package com.hewking.gank.data.type

/**
 * 项目名称：FlowChat
 * 类的描述：
 * 创建人员：hewking
 * 创建时间：2019/2/26 0026:16:20
 * 修改人员：hewking
 * 修改时间：2019/2/26 0026 16 20
 * 修改备注：
 * Version: 1.0.0
 */
data class ResourceType<T>(val state : Status
                           , val data : T
                           ,val msg : String) {

    enum class Status{
        CONTENT,LOADING,ERROR,NONET
    }

}