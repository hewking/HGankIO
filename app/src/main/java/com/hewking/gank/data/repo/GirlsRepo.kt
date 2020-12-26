package com.hewking.gank.data.repo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.hewking.gank.api.Api
import com.hewking.gank.data.database.AppDatabase
import com.hewking.gank.data.database.dao.GirlDao
import com.hewking.gank.data.entity.GirlEntity
import com.hewking.gank.infra.network.GankRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @program: HGankIO
 * @description: ${description}
 * @author: hewking
 * @create: 2019-02-23 17:31
 **/
class GirlsRepo(context: Context) {

    private lateinit var girls: LiveData<PagedList<GirlEntity>>

    private val girlDao: GirlDao = AppDatabase.getInstance(context).getGirlDao()

    private val service = GankRetrofit.create(Api::class.java)

    fun getGirls(): LiveData<PagedList<GirlEntity>> {
        girls = girlDao.getAllGirls().toLiveData(pageSize = 10)
        return girls
    }

    fun deleteFromCache(girl: GirlEntity) {
        girlDao.delete(girl)
    }

    suspend fun refresh() {
        val girls = service.getGirls()
        withContext(Dispatchers.IO){
            girlDao.insertAll(girls.data?:return@withContext)
        }

    }


}