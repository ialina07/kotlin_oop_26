package org.example.stack

import org.example.list.CustomArrayList
import org.example.list.CustomList

class ArrayListStack(private val list: CustomArrayList = CustomArrayList()) : Stack, CustomList by list {

    override fun push(value: Int) {
        add(value)
    }

    override fun pop(): Int {
        if (isEmpty) throw IllegalStateException("Stack is empty")
        return removeAt(size - 1)
    }

    override fun peek(): Int {
        if (isEmpty) throw IllegalStateException("Stack is empty")
        return get(size - 1)
    }

    override val isEmpty: Boolean
        get() = size == 0

    override fun clear() {
        while (!isEmpty) {
            pop()
        }
    }

    override fun toString(): String {
        if (isEmpty) return "[]"
        val sb = StringBuilder("[")
        for (i in size - 1 downTo 0) {
            sb.append(get(i))
            if (i > 0) sb.append(", ")
        }
        sb.append("]")
        return sb.toString()
    }
}