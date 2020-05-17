package com.hewking.gank.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hewking.gank.app.GankApplication
import com.hewking.gank.data.entity.GirlEntity
import com.hewking.gank.data.repo.GirlsRepo
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * @program: HGankIO
 *
 * @description: ${description}
 *
 * @author: hewking
 *
 * @create: 2019-02-23 14:42
 **/
class GirlsViewModel : ViewModel(){

    private val compositeDisposable by lazy {CompositeDisposable()}

    lateinit var data : LiveData<List<GirlEntity>>

    lateinit var girlsRepo: GirlsRepo

    fun init(){
        girlsRepo = GirlsRepo(GankApplication.getApp())
        data = girlsRepo.getGirls()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun deleteData(gankDayBean: GirlEntity) {
        GlobalScope.launch {
            girlsRepo.deleteFromCache(gankDayBean)
        }
    }

    fun refresh() {
//        girlsRepo.refresh()
    }

}


object GirlsViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GirlsViewModel() as T
    }
}