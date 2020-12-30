package com.hewking.gank.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.hewking.gank.app.GankApplication
import com.hewking.gank.data.entity.GirlEntity
import com.hewking.gank.data.repo.GirlsRepo
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.*
import javax.inject.Inject

/**
 * @program: HGankIO
 * @description: ${description}
 * @author: hewking
 * @create: 2019-02-23 14:42
 **/
class GirlsViewModel @ViewModelInject constructor(
    var girlsRepo: GirlsRepo
) : ViewModel(){

    var girls : LiveData<PagedList<GirlEntity>> = girlsRepo.getGirls().toLiveData(pageSize = 30)

    override fun onCleared() {
        super.onCleared()
    }

    fun deleteData(entity: GirlEntity) {
        GlobalScope.launch {
            girlsRepo.deleteFromCache(entity)
        }
    }

    fun reflesh(){
        viewModelScope.launch {
            girlsRepo.refresh()
        }
    }

}
