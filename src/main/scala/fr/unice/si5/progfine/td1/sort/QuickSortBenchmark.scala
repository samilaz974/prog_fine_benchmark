package fr.unice.si5.progfine.td1.sort

object QuickSortBenchmark { //Complexity O(nlog(n))


  def quickSort(array: Array[Int]): Array[Int] ={
    return sort(array, 0, array.length-1)
  }

  def sort(array: Array[Int], low : Int, high : Int): Array[Int] = {
    if(low < high){
      var pi = partition(array, low, high)

      sort(array, low, pi-1)
      sort(array, pi+1, high)
    }

    return array
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
