package samples

import org.junit._
import Assert._
import fr.unice.si5.progfine.App.benchmarkTest
import fr.unice.si5.progfine.td1.sort.{ArrayInitializer, CountingSortBenchmark, HeapSortBenchmark, InsertionSortBenchmark, MergeSortBenchmark, NativeSortBenchmark, QuickSortBenchmark, SelectionSortBenchmark}

@Test
class AppTest {

    @Test
    def testOK() = assertTrue(true)



    @Test
    def sortAlgoTest(): Unit ={
        val f1 = SelectionSortBenchmark.selectionSort _
        val f2 = InsertionSortBenchmark.insertionSort _
        val f3 = QuickSortBenchmark.quickSort _
        val f4 = MergeSortBenchmark.mergeSort _
        val f5 = CountingSortBenchmark.countingSort _
        val f6 = NativeSortBenchmark.native_sort _
        val f7 = HeapSortBenchmark.heapSort _

        // TODO: check the implementation of the Selection sort because the time outputed and time taken compared to the other algorithms is huge

        sortedTest("InsertionSort", f2)
        sortedTest("QuickSort", f3)
        sortedTest("MergeSort", f4)
        sortedTest("CountingSort", f5)
        sortedTest("NativeSort", f6)
        sortedTest("HeapSort", f7)
        sortedTest("SelectionSort", f1)
    }
    /**
     * Test to check if an Array[ Array[Int] ] is sorted
     * @param
     */
    def sortedTest(funcName: String, func: (Array[Int]) => Array[Int]): Unit ={
        val power = 5
        var arrays: Array[Array[Int]] = ArrayInitializer.buildArray(power, 10, 1000)

        //verify that all arrays are not sorted
        assert(!arrays.forall(x => sorted(x)))

        for (i <- 0 until arrays.length) {
            //println(arrays(i).mkString(" "))
            val sorted_array = func(arrays(i))
            //println(sorted_array.mkString(" "))
            assert(sorted(sorted_array))
        }

        println(funcName + " PASSED")
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


