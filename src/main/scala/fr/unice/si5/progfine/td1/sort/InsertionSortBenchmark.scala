package fr.unice.si5.progfine.td1.sort

object InsertionSortBenchmark { //Complexity O(n^2)

  private val nbLoop:Int = 10000000

  def sortBenchmark(): Unit ={

    var arrays:Array[Array[Int]] = ArrayInitializer.initialize(nbLoop)

    var beginning:Long = 0
    var end:Long = 0

    beginning = System.currentTimeMillis()
    for(i <- 0 to (nbLoop-1)){
      insertionSort(arrays(i))
    }
    end = System.currentTimeMillis()

    println("Total sorting time")
    println(end-beginning)

    println("Average time per insertion sort (ms)")
    println((end-beginning).toFloat/nbLoop)
  }

  def insertionSort(array: Array[Int]): Array[Int] = {

    for(i <- 0 until array.length){

      val hold = array(i)
      var holePos = i

      while(holePos > 0 && hold < array(holePos - 1)){
        array(holePos) = array(holePos - 1)
        holePos -= 1
      }

      array(holePos) = hold
    }

    array
  }
}
