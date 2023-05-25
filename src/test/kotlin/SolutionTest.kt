import kotlin.test.Test
import kotlin.test.assertContentEquals

class SolutionTest {
    @Test
    fun mergeTest() {
        assertContentEquals(
            merge(listOf(Interval(25, 30), Interval(2, 19), Interval(14, 23), Interval(4, 8))),
            listOf(Interval(2, 23), Interval(25, 30))
        )
    }

    @Test
    fun singleResult() {
        assertContentEquals(
            merge(listOf(Interval(1, 30), Interval(2, 19), Interval(14, 23), Interval(4, 8))),
            listOf(Interval(1, 30))
        )
    }

    @Test
    fun mergeTest2() {
        assertContentEquals(
            merge(listOf(Interval(1, 5), Interval(2, 6), Interval(5, 8), Interval(3, 4))),
            listOf(Interval(1, 8))
        )
    }

    @Test
    fun mergeTest3() {
        assertContentEquals(
            merge(listOf(Interval(1, 15), Interval(3, 4), Interval(5, 8), Interval(7, 9))),
            listOf(Interval(1, 15))
        )
    }

    @Test
    fun mergeTest4() {
        assertContentEquals(
            merge(listOf(Interval(1, 2), Interval(3, 4), Interval(5, 8), Interval(7, 9))),
            listOf(Interval(1, 2), Interval(3, 4), Interval(5, 9))
        )
    }

    @Test
    fun mergeTestWithMinus() {
        assertContentEquals(
            merge(listOf(Interval(-1, 2), Interval(-3, 4), Interval(5, 8), Interval(7, 9))),
            listOf(Interval(-3, 4), Interval(5, 9))
        )
    }
}