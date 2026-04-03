import org.example.SingleLinkedList
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SingleLinkedListTest {

    private lateinit var list: SingleLinkedList

    @BeforeEach
    fun setUp() {
        list = SingleLinkedList()
    }

    @Test
    fun `add elements`() {
        list.add(1)
        list.add(2)
        list.add(3)

        assertEquals(3, list.size)
        for (i in list.withIndex()) {
            assertEquals(i.index + 1, i.value)
        }
    }

    @Test
    fun `addFirst works correctly`() {
        list.add(2)
        list.addFirst(1)

        assertEquals(1, list[0])
        assertEquals(2, list[1])
    }

    @Test
    fun `remove element`() {
        list.add(1)
        list.add(2)
        list.add(3)

        assertTrue(list.remove(2))
        assertEquals(2, list.size)
        assertEquals(1, list[0])
        assertEquals(3, list[1])
    }

    @Test
    fun `remove non-existing element`() {
        list.add(1)
        list.add(2)

        val removed = list.remove(3)
        assertFalse(removed)
        assertEquals(2, list.size)
    }

    @Test
    fun `contains works`() {
        list.add(1)
        list.add(2)

        assertTrue(list.contains(1))
        assertFalse(list.contains(3))
    }

    @Test
    fun `get by index`() {
        list.add(10)
        list.add(20)
        list.add(30)

        assertEquals(10, list[0])
        assertEquals(20, list[1])
        assertEquals(30, list[2])
    }

    @Test
    fun `get throws exception on invalid index`() {
        list.add(10)
        list[0]

        assertThrows(IndexOutOfBoundsException::class.java) {
            list[5]
        }
    }

    // Fixed (index(20) = 1)
    @Test
    fun `indexOf works`() {
        list.add(10)
        list.add(20)
        list.add(30)

        assertEquals(1, list.indexOf(20))
    }

    @Test
    fun `set works`() {
        list.add(10)
        list.add(20)
        list.add(30)

        list[2] = 5
        assertEquals(5, list[2])
    }

    // Test adding and removing from empty list edge cases
    @Test
    fun `custom test - add and remove from empty list`() {
        assertFalse(list.remove(1))
        assertEquals(0, list.size)

        list.addFirst(100)
        assertEquals(1, list.size)
        assertEquals(100, list[0])

        val newList = SingleLinkedList()
        newList.add(200)
        assertEquals(1, newList.size)
        assertEquals(200, newList[0])
    }

    // Test duplicate values handling
    @Test
    fun `custom test - duplicate values`() {
        list.add(5)
        list.add(5)
        list.add(5)
        list.add(10)

        assertEquals(4, list.size)

        assertEquals(0, list.indexOf(5))

        assertTrue(list.remove(5))
        assertEquals(3, list.size)
        assertEquals(5, list[0])
        assertEquals(5, list[1])
        assertEquals(10, list[2])

        list.remove(5)
        list.remove(5)
        assertEquals(1, list.size)
        assertEquals(10, list[0])
    }

    // Test multiple addFirst and set operations
    @Test
    fun `custom test - addFirst and set combination`() {
        list.add(10)
        list.add(20)
        list.add(30)

        list.addFirst(5)
        list.addFirst(1)

        assertEquals(5, list.size)
        assertEquals(1, list[0])
        assertEquals(5, list[1])
        assertEquals(10, list[2])
        assertEquals(20, list[3])
        assertEquals(30, list[4])

        list[0] = 100
        list[2] = 200
        list[4] = 300

        assertEquals(100, list[0])
        assertEquals(5, list[1])
        assertEquals(200, list[2])
        assertEquals(20, list[3])
        assertEquals(300, list[4])

        assertEquals(5, list.size)
    }
}