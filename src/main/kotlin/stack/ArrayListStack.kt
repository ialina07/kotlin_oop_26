package org.example.stack

import org.example.list.CustomArrayList

class ArrayListStack(private val list: CustomArrayList = CustomArrayList()) : Stack {

    override fun push(value: Int) {
        list.add(value)
    }

    override fun pop(): Int {
        if (isEmpty) throw IllegalStateException("Stack is empty")
        return list.removeAt(list.size - 1)
    }

    override fun peek(): Int {
        if (isEmpty) throw IllegalStateException("Stack is empty")
        return list.get(list.size - 1)
    }

    override val isEmpty: Boolean
        get() = list.size == 0
}