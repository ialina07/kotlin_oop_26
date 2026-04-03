package org.example

class SingleLinkedList : CustomList {

    private var head: Node? = null
    private var tail: Node? = null
    private var _size: Int = 0

    override val size: Int
        get() = _size

    // Node class representing each element
    private class Node(
        var value: Int,
        var next: Node? = null
    )

    // Add element to the end of the list
    override fun add(element: Int) {
        val newNode = Node(element)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            tail = newNode
        }
        _size++
    }

    // Update value at specific index
    override operator fun set(index: Int, value: Int) {
        checkIndex(index)
        val node = getNode(index)
        node?.value = value
    }

    // Add element to the beginning of the list
    override fun addFirst(element: Int) {
        val newNode = Node(element)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            newNode.next = head
            head = newNode
        }
        _size++
    }

    // Get element at specific index
    override operator fun get(index: Int): Int {
        checkIndex(index)
        return getNode(index)?.value ?: throw IndexOutOfBoundsException("Index: $index, Size: $size")
    }

    // Find first occurrence index of element, return -1 if not found
    override fun indexOf(element: Int): Int {
        var current = head
        var index = 0
        while (current != null) {
            if (current.value == element) {
                return index
            }
            current = current.next
            index++
        }
        return -1
    }

    // Remove first occurrence of element, return true if removed
    override fun remove(element: Int): Boolean {
        var current = head
        var prev: Node? = null

        while (current != null) {
            if (current.value == element) {
                if (prev == null) {
                    // Removing head node
                    head = current.next
                    if (head == null) {
                        tail = null
                    }
                } else {
                    // Removing middle or tail node
                    prev.next = current.next
                    if (current.next == null) {
                        tail = prev
                    }
                }
                _size--
                return true
            }
            prev = current
            current = current.next
        }
        return false
    }

    // Returns iterator for traversing the list
    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            private var current = head

            override fun hasNext(): Boolean {
                return current != null
            }

            override fun next(): Int {
                if (!hasNext()) throw NoSuchElementException()
                val value = current?.value ?: throw NoSuchElementException()
                current = current?.next
                return value
            }
        }
    }

    // Helper function: check if index is valid
    private fun checkIndex(index: Int) {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index: $index, Size: $size")
        }
    }

    // Helper function: get node at specific index
    private fun getNode(index: Int): Node? {
        var current = head
        var i = 0
        while (i < index && current != null) {
            current = current.next
            i++
        }
        return current
    }

    companion object {
        fun singleLinkedListOf(vararg items: Int) =
            items.fold(SingleLinkedList()) { list, item ->
                list.also{ it.add(item) }
            }
    }
}