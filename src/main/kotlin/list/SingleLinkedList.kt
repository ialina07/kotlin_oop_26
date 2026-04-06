package org.example.list

abstract class SingleLinkedList : CustomList {

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
        getNode(index).value = value
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
        return getNode(index).value
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

    override fun removeAt(index: Int): Int {
        checkIndex(index)

        if (index == 0) {
            val value = head?.value ?: throw IllegalStateException("List is empty")
            head = head?.next
            if (head == null) {
                tail = null
            }
            _size--
            return value
        }

        val prev = getNode(index - 1)
        val current = prev.next ?: throw IndexOutOfBoundsException("Node not found")
        val value = current.value

        prev.next = current.next
        if (current.next == null) {
            tail = prev
        }

        _size--
        return value
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

    override fun toString(): String {
        if (head == null) return "[]"

        val sb = StringBuilder("[")
        var current = head
        var first = true

        while (current != null) {
            if (!first) sb.append(", ")
            sb.append(current.value)
            first = false
            current = current.next
        }
        sb.append("]")
        return sb.toString()
    }

    // Helper function: check if index is valid
    private fun checkIndex(index: Int) {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index: $index, Size: $size")
        }
    }

    // Helper function: get node at specific index
    private fun getNode(index: Int): Node {
        var current = head
        var i = 0
        while (i < index) {
            current = current?.next ?: throw IndexOutOfBoundsException("Index: $index, Size: $size")
            i++
        }
        return current ?: throw IndexOutOfBoundsException("Index: $index, Size: $size")
    }
}