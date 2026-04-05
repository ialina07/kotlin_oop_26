package org.example.list

interface CustomList : Iterable<Int> {
    operator fun get(index: Int): Int
    operator fun set(index: Int, value: Int)
    fun add(element: Int)
    fun addFirst(element: Int)
    fun remove(element: Int): Boolean
    fun removeAt(index: Int): Int
    fun indexOf(element: Int): Int
    val size: Int
}