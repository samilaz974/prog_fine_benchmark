package fr.unice.si5.progfine.td1.sort

object QuickSortBenchmark { //Complexity O(nlog(n))

  private val nbLoop:Int = 10000000

  def sortBenchmark(): Unit ={

    var arrays:Array[Array[Int]] = ArrayInitializer.initialize(nbLoop)

    var beginning:Long = 0
    var end:Long = 0

    beginning = System.currentTimeMillis()
    for(i <- 0 to (nbLoop-1)){
      quickSort(arrays(i))
    }
    end = System.currentTimeMillis()

    println("Average time per quick sort (ms)")
    println((end-beginning).toFloat/nbLoop)
  }

  def quickSort(array: Array[Int]): Unit ={
    sort(array, 0, array.length-1)
  }

  def sort(array: Array[Int], low : Int, high : Int): Unit = {
    if(low < high){
      var pi = partition(array, low, high)

      sort(array, low, pi-1)
      sort(array, pi+1, high)
    }
  }

  def partition(array: Array[Int], low : Int, high : Int): Int = {
    var pivot = array(high)
    var i = (low-1)
    for (j <- low until high){
      if(array(j) < pivot){
        i+=1

        // If current element is smaller than the pivot
        var temp = array(i)
        array(i) = array(j)
        array(j) = temp
      }
    }

    var temp = array(i+1)
    array(i+1) = array(high)
    array(high) = temp

    return i+1
  }

}
