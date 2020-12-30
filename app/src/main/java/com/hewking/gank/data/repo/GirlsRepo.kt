package com.hewking.gank.data.repo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.hewking.gank.api.Api
import com.hewking.gank.data.database.dao.GirlDao
import com.hewking.gank.data.entity.GirlEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @program: HGankIO
 * @description: ${description}
 * @author: hewking
 * @create: 2019-02-23 17:31
 **/
class GirlsRepo constructor(
    context: Context,
    private val girlDao: GirlDao,
    private val service: Api) {

  fun getGirls(): DataSource.Factory<Int, GirlEntity> {
    return girlDao.getAllGirls()
  }

  fun deleteFromCache(girl: GirlEntity) {
    girlDao.delete(girl)
  }

  suspend fun refresh() {
    val girls = service.getGirls()
    withContext(Dispatchers.IO) {
      girlDao.insertAll(girls.data ?: return@withContext)
    }

  }


}