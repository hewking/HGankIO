package com.github.gank

import org.junit.Test

/**
 * @program: HGankIO
 * @author: hewking
 * @create: 2019-02-23 21:12
 * @description: ${description}
 **/
class ExampleTest {

    @Test
    fun f(){
        val f = t(7)

        println(f(2))

        println(f(1))
    }

    fun t(n : Int) : (i : Int) -> Int {
        return {
            it + n
        }
    }
}