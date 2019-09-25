package fr.unice.si5.progfine.td1.sort

object InsertionSortBenchmark { //Complexity O(n^2)



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
