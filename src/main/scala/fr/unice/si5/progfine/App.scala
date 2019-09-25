package fr.unice.si5.progfine

import fr.unice.si5.progfine.td1.OperatorBenchmark
import fr.unice.si5.progfine.td1.sort.{CountingSortBenchmark, HeapSortBenchmark, MergeSortBenchmark, NativeSortBenchmark, QuickSortBenchmark, SelectionSortBenchmark}

/**
 * @author ${user.name}
 */
object App {
  
  def main(args : Array[String]) {
    println( "---BENCHMARKING---" )
    //OperatorBenchmark.additionBenchmark()
    //OperatorBenchmark.multiplicationBenchmark()
    //OperatorBenchmark.compareOperatorBenchmark()
    SelectionSortBenchmark.sortBenchmark()
    MergeSortBenchmark.sortBenchmark()
    HeapSortBenchmark.sortBenchmark()
    CountingSortBenchmark.sortBenchmark()
    NativeSortBenchmark.sortBenchmark()
    QuickSortBenchmark.sortBenchmark()
  }

}
