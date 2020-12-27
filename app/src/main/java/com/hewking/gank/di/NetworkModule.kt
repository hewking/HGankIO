package com.hewking.gank.di

import com.hewking.gank.api.Api
import com.hewking.gank.infra.network.GankRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 *@Description: (用一句话描述该文件做什么)
 *@Author: jianhao
 *@Date:   12/27/20 11:41 PM
 *@License: Copyright Since 2020 Hive Box Technology. All rights reserved.
 *@Notice: This content is limited to the internal circulation of Hive Box,
 and it is prohibited to leak or used for other commercial purposes.
 */
@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

  @Singleton
  @Provides
  fun providerApiService(): Api {
    return GankRetrofit.create(Api::class.java)
  }


}