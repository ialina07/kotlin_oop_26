package org.example.list

class SingleLinkedList : CustomList {
    // don't use any java/kotlin internal datastructures like lists))
    // write from scratch))


    override val size: Int
        get() = TODO("Implement this")

    override fun add(element: Int) {
        TODO("Implement this")
    }

    override operator fun set(index: Int, value: Int) {
        TODO("Implement this")
    }

    override fun addFirst(element: Int) {
        TODO("Implement this")
    }

    override operator fun get(index: Int): Int {
        TODO("Implement this")
    }

    override fun indexOf(element: Int): Int {
        TODO("Implement this")
    }

    override fun remove(element: Int): Boolean {
        TODO("Implement this")
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            override fun hasNext(): Boolean {
                TODO("Implement this")
            }

            override fun next(): Int {
                TODO("Implement this")
            }
        }
    }

    companion object {
        fun singleLinkedListOf(vararg items: Int) =
            items.fold(SingleLinkedList()) { list, item ->
                list.also { it.add(item) }
            }
    }
}