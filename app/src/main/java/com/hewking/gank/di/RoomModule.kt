package com.hewking.gank.di

import android.app.Application
import android.content.Context
import com.hewking.gank.data.database.AppDatabase
import com.hewking.gank.data.database.dao.GirlDao
import com.hewking.gank.data.repo.GirlsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 *@Description: (用一句话描述该文件做什么)
 *@Author: jianhao
 *@Date:   12/27/20 11:40 PM
 *@License: Copyright Since 2020 Hive Box Technology. All rights reserved.
 *@Notice: This content is limited to the internal circulation of Hive Box,
 and it is prohibited to leak or used for other commercial purposes.
 */
@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

  @Singleton
  @Provides
  fun provideGirlDao(
      context: Application
  ): GirlDao {
    return AppDatabase.getInstance(context).getGirlDao()
  }

}