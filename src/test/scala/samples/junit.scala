package samples

import org.junit._
import Assert._

@Test
class AppTest {

    @Test
    def testOK() = assertTrue(true)

//    @Test
//    def testKO() = assertTrue(false)

    /**
     * Test to check if an Array[ Array[Int] ] is sorted
     * @param arrays
     */
    def sortedTest(arrays: Array[Array[Int]]): Unit ={
        assert(arrays.forall(x => sorted(x)))
    }

    def sorted(array: Array[Int]): Boolean = {
        var last = -1

        // If every item is greater than or equal to the last, then the list is sorted.
        array.forall(curr => {
            val isGreater = curr >= last
            last = curr
            isGreater
        })
    }

}


