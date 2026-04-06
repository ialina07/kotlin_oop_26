package org.example.stack

import org.example.list.SingleLinkedList

class SingleLinkedStack : SingleLinkedList(), Stack {

    override fun push(value: Int) {
        addFirst(value)
    }

    override fun pop(): Int {
        if (isEmpty) throw IllegalStateException("Stack is empty")
        return removeAt(0)
    }

    override fun peek(): Int {
        if (isEmpty) throw IllegalStateException("Stack is empty")
        return get(0)
    }

    override val isEmpty: Boolean
        get() = size == 0

    override fun clear() {
        while (!isEmpty) {
            pop()
        }
    }
}