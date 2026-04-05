package org.example

import org.example.list.CustomArrayList
import org.example.list.CustomList
import org.example.list.SingleLinkedList
import org.example.stack.ArrayListStack
import org.example.stack.SingleLinkedStack
import org.example.stack.Stack

class ListPrinter {

    fun printList(collection: Any) {
        when (collection) {
            is CustomArrayList -> printCustomList(collection, "CustomArrayList")
            is SingleLinkedList -> printCustomList(collection, "SingleLinkedList")
            is SingleLinkedStack -> printStack(collection, "SingleLinkedStack")
            is ArrayListStack -> printStack(collection, "ArrayListStack")
            else -> println("Unknown collection type")
        }
    }

    private fun printCustomList(list: CustomList, name: String) {
        print("$name (size=${list.size}): [")
        for (i in 0 until list.size) {
            print(list.get(i))
            if (i < list.size - 1) print(", ")
        }
        println("]")
    }

    private fun printStack(stack: Stack, name: String) {
        println("$name: $stack")
    }
}