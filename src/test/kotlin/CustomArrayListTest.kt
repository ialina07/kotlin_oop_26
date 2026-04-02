import org.example.list.CustomArrayList
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CustomArrayListTest {

    private lateinit var list: CustomArrayList

    @BeforeEach
    fun setUp() {
        list = CustomArrayList(10)
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

    @Test
    fun `resize works`() {
        // This test is specific to CustomArrayList internal implementation
        // We can test by adding more elements than initial capacity
        val smallList = CustomArrayList(2)
        smallList.add(1)
        smallList.add(2)
        smallList.add(3) // This should trigger resize

        assertEquals(3, smallList.size)
        assertEquals(1, smallList[0])
        assertEquals(2, smallList[1])
        assertEquals(3, smallList[2])
    }
}