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

sealed class Result<out T: Any> {

  data class Success<out T: Any>(val data: T): Result<T>()
  data class Error(val e: Exception): Result<Nothing>()

  override fun toString(): String {
    return when(this) {
      is Success -> "Success[data:$data]"
      is Error -> "Error[exception:$e]"
    }
  }

}

data class BaseResponse<T>(
    val status: Int,
    val data: T?
)
