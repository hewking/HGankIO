package com.hewking.gank

import io.reactivex.Observable
import org.junit.Test

/**
 * 项目名称：FlowChat
 * 类的描述：
 * 创建人员：hewking
 * 创建时间：2020/2/17 0017:11:08
 * 修改人员：hewking
 * 修改时间：2020/2/17 0017 11 08
 * 修改备注：
 * Version: 1.0.0
 */
class RxJavaMapTest {

    @Test
    fun testMap() {
        val tom = Student("tom",18, mutableListOf(Course(("chinese"))))
        val mary = Student("mary",20, mutableListOf(Course("math"),Course("PE")))
        val students = mutableListOf(tom,mary)
        Observable.fromIterable(students)
                .flatMap {
                    Observable.fromIterable(it.coerces)
                }.subscribe {
                    println(it.subject)
                }
    }

    @Test
    fun testFlatMap() {
        val tom = Student("tom",18)
        val mary = Student("mary",20)
        val students = mutableListOf(tom,mary)
        Observable.just(students)
                .flatMap { it ->
                    Observable.fromArray(it).map { it.size }
                }.subscribe {
                    println("name: $it")
                }
    }

    data class Student(val name: String,
                       val age: Int,
                       val coerces: List<Course>? = mutableListOf())

    data class Course(val subject: String)

}