package fr.unice.si5.progfine.td1.sort

object SelectionSortBenchmark { //Complexity O(n²)

  private val nbLoop:Int = 10000000


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
