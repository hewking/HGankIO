package com.hewking.gank.di

import android.app.Application
import android.content.Context
import com.hewking.gank.data.repo.GirlsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 *@Description: (用一句话描述该文件做什么)
 *@Author: jianhao
 *@Date:   12/26/20 4:22 PM
 *@License: Copyright Since 2020 Hive Box Technology. All rights reserved.
 *@Notice: This content is limited to the internal circulation of Hive Box,
 and it is prohibited to leak or used for other commercial purposes.
 */

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

  @Singleton
  @Provides
  fun provideGirlsRepository(
      context: Application
  ): GirlsRepo {
    return GirlsRepo(context)
  }

}