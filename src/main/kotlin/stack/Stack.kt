package org.example.stack

import org.example.list.CustomList

interface Stack : CustomList {
    // Add item to stack
    fun push(value: Int)

    // Get and remove top item from stack
    fun pop(): Int

    // Get top item from stack
    fun peek(): Int

    // Check if stack is empty
    val isEmpty: Boolean

    // Check if stack is empty
    fun clear()
}