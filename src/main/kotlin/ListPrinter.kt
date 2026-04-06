package org.example

import org.example.list.CustomList
import org.example.stack.Stack

class ListPrinter {

    fun printList(collection: CustomList) {
        println("${collection::class.simpleName} (size=${collection.size}): $collection")
    }
}