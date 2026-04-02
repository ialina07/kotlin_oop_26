package org.example.list

class CustomArrayList(size: Int) {
    val inner = IntArray(size)

    // TODO: implement interface CustomList

    fun add(value: Int) {
        TODO("implement this")
    }

    private fun resize(newSize: Int): CustomArrayList {
        TODO("implement this")
        // should return new array list with newSize size
        // and first size elements copied from this
    }

    companion object {
        fun customArrayListOf(vararg items: Int) =
            items.fold(CustomArrayList(items.size)) { list, item ->
                list.also { it.add(item) }
            }
    }
}