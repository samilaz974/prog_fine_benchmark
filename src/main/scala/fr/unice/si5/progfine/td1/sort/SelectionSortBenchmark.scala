package fr.unice.si5.progfine.td1.sort

object SelectionSortBenchmark {

  private val nbLoop:Int = 100000

  def sortBenchmark(): Unit ={

    var arrays:Array[Array[Int]] = ArrayInitializer.initialize(nbLoop)

    var beginning:Long = 0
    var end:Long = 0

    beginning = System.currentTimeMillis()
    for(i <- 0 to (nbLoop-1)){
      selectionSort(arrays(i))
    }
    end = System.currentTimeMillis()

    println("Total sorting time")
    println(end-beginning)

    println("Average time per selection sort (ms)")
    println((end-beginning).toFloat/nbLoop)
  }

  def selectionSort(input: Array[Int]): Array[Int] = {
    val inputSize: Int = input.length

    for (currentMin <- 0 to (inputSize-1)){
      var min_index = currentMin

      //Find the lowest in the following of the array
      for(currentItem <- 0 to (inputSize-1)){
        if(input(currentItem) < input(min_index)){
          min_index = currentItem
        }

        //Swap values
        val temp = input(min_index)
        input(min_index) = input(currentMin)
        input(currentMin) = temp
      }
    }
    return input
  }
}
