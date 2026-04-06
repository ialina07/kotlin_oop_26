package org.example.list

class CustomArrayList(initialCapacity: Int = 10) : CustomList {
    private var inner = IntArray(initialCapacity)
    private var _size = 0

    override val size:
            Int get() = _size

    override fun get(index: Int): Int {
        checkIndex(index)
        return inner[index]
    }

    override fun set(index: Int, value: Int) {
        checkIndex(index)
        inner[index] = value
    }

    override fun add(element: Int) {
        if (_size == inner.size) {
            inner = resize(inner.size * 2, shiftRight = false)
        }
        inner[_size] = element
        _size++
    }

    override fun addFirst(element: Int) {
        if (_size == inner.size) {
            inner = resize(inner.size * 2, shiftRight = true)
        } else {
            for (i in _size downTo 1) {
                inner[i] = inner[i - 1]
            }
        }
        inner[0] = element
        _size++
    }

    override fun remove(element: Int): Boolean {
        val index = indexOf(element)
        if (index == -1) return false
        for (i in index until _size - 1) {
            inner[i] = inner[i + 1]
        }
        _size--
        return true
    }

    override fun removeAt(index: Int): Int {
        checkIndex(index)
        val removedValue = inner[index]
        for (i in index until _size - 1) {
            inner[i] = inner[i + 1]
        }
        _size--
        return removedValue
    }

    override fun indexOf(element: Int): Int {
        for (i in 0 until _size) {
            if (inner[i] == element) return i
        }
        return -1
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            private var current = 0
            override fun hasNext(): Boolean = current < _size
            override fun next(): Int = get(current++)
        }
    }

    private fun resize(newSize: Int, shiftRight: Boolean = false): IntArray {
        val newInner = IntArray(newSize)
        if (shiftRight) {
            // копируем со сдвигом вправо на 1 (для addFirst)
            System.arraycopy(inner, 0, newInner, 1, _size)
        } else {
            System.arraycopy(inner, 0, newInner, 0, _size)
        }
        return newInner
    }

    private fun checkIndex(index: Int) {
        if (index < 0 || index >= _size) {
            throw IndexOutOfBoundsException("Index: $index, Size: $_size")
        }
    }

    override fun toString(): String {
        return inner.sliceArray(0 until _size).joinToString(", ", "[", "]")
    }

    companion object {
        fun customArrayListOf(vararg items: Int): CustomArrayList {
            val list = CustomArrayList(items.size)
            for (item in items) {
                list.add(item)
            }
            return list
        }
    }
}