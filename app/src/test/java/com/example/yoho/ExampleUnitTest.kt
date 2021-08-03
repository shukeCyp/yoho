package com.example.yoho

import android.util.Log
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        var list:MutableList<String> = mutableListOf()
        list.add("a")
        list.add("b")
        list.add("c")
        list.add("d")
        list.add("e")
        list.add("f")
        var iterator = list.iterator()
        while(iterator.hasNext()){
            var next = iterator.next()
            if (next.equals("c")){
                iterator.remove()
            }
        }
        list.forEach {
            System.out.println(it)
        }
    }
}