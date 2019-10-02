package fr.unice.si5.progfine.sort

object SelectionSortBenchmark {

  //Complexity O(n²)
  //From http://thescalatutorial.blogspot.com/2013/07/selection-sort-code-in-scala.html
  def selectionSort(input: Array[Int]): Array[Int] = {

    def findMin(array: Array[Int], start: Int): Int = {
      var minIndex = start
      for (i <- start until array.size) {
        if (array(i) < array(minIndex)) {
          minIndex = i
        }
      }
      minIndex
    }

    def bubbleSortRecursive(array: Array[Int], start: Int): Array[Int] = {
      val minIndex = findMin(array, start)
      start match {
        case _ if (start >= array.size - 1) => array
        case _ =>
          var temp = array(start)
          array(start) = array(minIndex)
          array(minIndex) = temp
          bubbleSortRecursive(array, start + 1)
      }
    }
    bubbleSortRecursive(input, 0)
  }
}
