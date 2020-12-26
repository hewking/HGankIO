package com.hewking.gank.infra.network

/**
 * 定义网络请求api的状态码
 */
object StatusCode {

  /**
   * 成功
   */
  const val success = 100;

}

sealed class Status(code: Int) {

  object Success : Status(StatusCode.success)

}

open class Result {

  class Success : Result()

  class Error : Result()

}

class Resources

data class CommonResult<T>(
    val status: Int,
    val data: T?
)