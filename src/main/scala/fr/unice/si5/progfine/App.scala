package fr.unice.si5.progfine

import java.io.File

import com.github.tototoshi.csv.CSVWriter
import fr.unice.si5.progfine.td1.sort.{ArrayInitializer, CountingSortBenchmark, HeapSortBenchmark, InsertionSortBenchmark, MergeSortBenchmark, NativeSortBenchmark, QuickSortBenchmark, SelectionSortBenchmark}


/**
 * @author ${user.name}
 */
object App {

  def main(args: Array[String]) {


    val f1 = SelectionSortBenchmark.selectionSort _
    val f2 = InsertionSortBenchmark.insertionSort _
    val f3 = QuickSortBenchmark.quickSort _
    val f4 = MergeSortBenchmark.mergeSort _
    val f5 = CountingSortBenchmark.countingSort _
    val f6 = NativeSortBenchmark.native_sort _
    val f7 = HeapSortBenchmark.heapSort _

    // TODO: check the implementation of the Selection sort because the time outputed and time taken compared to the other algorithms is huge



    // INFORMATION IMPORTANTE, a puissance 16, outof memory error: Java heap space

    benchmarkTest("InsertionSort", f2)
    benchmarkTest("QuickSort", f3)
    benchmarkTest("MergeSort", f4)
    benchmarkTest("CountingSort", f5)
    benchmarkTest("NativeSort", f6)
    benchmarkTest("HeapSort", f7)
    benchmarkTest("SelectionSort", f1)



  }

  def benchmarkTest(funcName: String, func: (Array[Int]) => Array[Int]) = {
    val f = new File(funcName + ".csv")

    val writer = CSVWriter.open(f)

    //Write the column names
    writer.writeRow(List("power", "start_time", "stop_time"))


    val powerLimit: Int = 20

    for (power <- 1 to powerLimit) {
      var arrays: Array[Array[Int]] = ArrayInitializer.buildArray(power, 1000, 1000)
      val startTime = System.currentTimeMillis()

      for (i <- 0 until arrays.length) {
        func(arrays(i))
      }

      val stopTime = System.currentTimeMillis()

      writer.writeRow(List(power, startTime, stopTime))
      println(s"Sorting function: $funcName Runtime: ${stopTime - startTime}ms")

    }
    writer.close()
  }


}