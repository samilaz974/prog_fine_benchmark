package fr.unice.si5.progfine.td1.sort

object NativeSortBenchmark {

  private val nbLoop:Int = 10000000

  def sortBenchmark(): Unit ={

    var arrays:Array[Array[Int]] = ArrayInitializer.initialize(nbLoop)

    var beginning:Long = 0
    var end:Long = 0

    beginning = System.currentTimeMillis()
    for(i <- 0 to (nbLoop-1)){
      arrays(i).sorted
    }
    end = System.currentTimeMillis()

    println("Average time per native sort (ms)")
    println((end-beginning).toFloat/nbLoop)
  }
}
