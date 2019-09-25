package fr.unice.si5.progfine

import fr.unice.si5.progfine.td1.OperatorBenchmark
import fr.unice.si5.progfine.td1.sort.InsertionSortBenchmark.nbLoop
import fr.unice.si5.progfine.td1.sort.{ArrayInitializer, HeapSortBenchmark, InsertionSortBenchmark, MergeSortBenchmark, SelectionSortBenchmark}

/**
 * @author ${user.name}
 */
object App {
  
  def main(args : Array[String]) {
    println( "---BENCHMARKING---" )
    //OperatorBenchmark.additionBenchmark()
    //OperatorBenchmark.multiplicationBenchmark()
    //OperatorBenchmark.compareOperatorBenchmark()
    //MergeSortBenchmark.sortBenchmark()
    //HeapSortBenchmark.sortBenchmark()
    //SelectionSortBenchmark.sortBenchmark()
    //InsertionSortBenchmark.sortBenchmark()
    var arrays:Array[Array[Int]] = ArrayInitializer.initializePowerArrays(4, 2, 10)



  }

}
