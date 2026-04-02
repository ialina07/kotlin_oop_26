import org.example.stack.ArrayListStack
import org.example.stack.Stack
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ArrayListStackTest {

    private lateinit var stack: ArrayListStack

    @BeforeEach
    fun setUp() {
        stack = ArrayListStack()
    }

    @Test
    fun `push elements`() {
        stack.push(1)
        stack.push(2)
        stack.push(3)

        assertEquals(3, stack.size)
        // Stack order: LIFO, so peek should return last pushed
        assertEquals(3, stack.peek())
    }

    @Test
    fun `pop works correctly`() {
        stack.push(1)
        stack.push(2)
        stack.push(3)

        assertEquals(3, stack.pop())
        assertEquals(2, stack.size)
        assertEquals(2, stack.peek())
    }

    @Test
    fun `peek returns top without removal`() {
        stack.push(10)
        stack.push(20)

        assertEquals(20, stack.peek())
        assertEquals(2, stack.size)
    }

    @Test
    fun `isEmpty works`() {
        assertTrue(stack.isEmpty)
        stack.push(5)
        assertFalse(stack.isEmpty)
        stack.pop()
        assertTrue(stack.isEmpty)
    }

    @Test
    fun `add elements via CustomList interface`() {
        stack.add(1)
        stack.add(2)
        stack.add(3)

        assertEquals(3, stack.size)
        for (i in stack.withIndex()) {
            assertEquals(i.index + 1, i.value)
        }
    }

    @Test
    fun `addFirst works correctly`() {
        stack.add(2)
        stack.addFirst(1)

        assertEquals(1, stack[0])
        assertEquals(2, stack[1])
    }

    @Test
    fun `remove element`() {
        stack.add(1)
        stack.add(2)
        stack.add(3)

        assertTrue(stack.remove(2))
        assertEquals(2, stack.size)
        assertEquals(1, stack[0])
        assertEquals(3, stack[1])
    }

    @Test
    fun `remove non-existing element`() {
        stack.add(1)
        stack.add(2)

        val removed = stack.remove(3)
        assertFalse(removed)
        assertEquals(2, stack.size)
    }

    @Test
    fun `contains works`() {
        stack.add(1)
        stack.add(2)

        assertTrue(stack.contains(1))
        assertFalse(stack.contains(3))
    }

    @Test
    fun `get by index`() {
        stack.add(10)
        stack.add(20)
        stack.add(30)

        assertEquals(10, stack[0])
        assertEquals(20, stack[1])
        assertEquals(30, stack[2])
    }

    @Test
    fun `get throws exception on invalid index`() {
        stack.add(10)
        stack[0]

        assertThrows(IndexOutOfBoundsException::class.java) {
            stack[5]
        }
    }

    @Test
    fun `indexOf works`() {
        stack.add(10)
        stack.add(20)
        stack.add(30)

        assertEquals(1, stack.indexOf(20))
    }

    @Test
    fun `set works`() {
        stack.add(10)
        stack.add(20)
        stack.add(30)

        stack[2] = 5
        assertEquals(5, stack[2])
    }

    @Test
    fun `pop on empty stack throws exception`() {
        assertThrows(NoSuchElementException::class.java) {
            stack.pop()
        }
    }

    @Test
    fun `peek on empty stack throws exception`() {
        assertThrows(NoSuchElementException::class.java) {
            stack.peek()
        }
    }
}