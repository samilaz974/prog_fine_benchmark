package fr.unice.si5.progfine

import fr.unice.si5.progfine.td1.OperatorBenchmark
import fr.unice.si5.progfine.td1.sort.{ArrayInitializer, HeapSortBenchmark, InsertionSortBenchmark, MergeSortBenchmark, QuickSortBenchmark, SelectionSortBenchmark}

/**
 * @author ${user.name}
 */
object App {
  
  def main(args : Array[String]) {



    benchmarkTest("SelectionSort", selectionSort)
    benchmarkTest("InsertionSort", insertionSort)
    benchmarkTest("QuickSort", quickSort)
    benchmarkTest("MergeSort", mergeSort)

    /*val sortFunctions = Array(SelectionSortBenchmark.selectionSort _, InsertionSortBenchmark.insertionSort _, MergeSortBenchmark.merge _, HeapSortBenchmark.heapSort _, QuickSortBenchmark.quickSort _)
    val fnList: Array[Array[Int] => Array[Int]] = Array( , insertionSort , mergeSort , heapSort ,quickSort)
    val fnList: Array[(Int, Int) => Int] = Array(f1, f2, f3)
    for (func <- sortFunctions){
      benchmarkTest(func, arrays)}
}   */

  }

  def benchmarkTest(funcName:String, func: (Array[Int]) => Array[Int]) = {

    // verify that all arrays are not sorted
    //assert(!arrays.forall(x => sorted(x)))
    val powerLimit:Int = 10

    for (power <- 0 to powerLimit){
      var arrays:Array[Array[Int]] = ArrayInitializer.buildArray(power, 1000, 1000)

      val startTime = System.currentTimeMillis()

      for(i <- 0 until arrays.length){
        func(arrays(i))
      }

      val stopTime = System.currentTimeMillis()


    }



    println(s"Sorting function: $funcName Runtime: ${stopTime - startTime}ms Standard Deviation: $stanDev Sorted: $isSorted")

  }




  // SORT ALGORITHMS //

  // INSERTION SORT
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

  //HEAP SORT//
  def heapSort(input: Array[Int]): Array[Int] = {
    val n = input.length

    //Build heap (rearrange array)
    for(i <- (n/2 - 1) to 0 by -1){
      heapify(input, n, i)
    }

    for(i <- (n-1) to 0 by -1){
      //Move the current root to end
      val temp = input(0)
      input(0) = input(i)
      input(i) = temp

      heapify(input, i, 0)
    }
    return input
  }

  def heapify(input: Array[Int], n: Int, i: Int): Unit ={
    //Initiliaze largest node as root
    var largest = i
    var l = 2*i+1
    var r = 2*i+2

    if(l<n && input(l)>input(largest)){
      largest = l
    }

    if(r<n && input(r)>input(largest)){
      largest = r
    }

    if(largest != i){
      var temp = input(i)
      input(i) = input(largest)
      input(largest) = temp

      //Recursively heapify the affected sub-tree
      heapify(input, n, largest)
    }
  }



  // MERGESORT
  def mergeSort(array: Array[Int]): Array[Int] ={
    return sort(array, 0, array.length-1)
  }

  def sort(input: Array[Int], l:Int, r:Int): Array[Int] = {
    if(l<r){
      //Find the middle point
      var m = (l+r)/2

      //Sort first and second halves
      sort(input, l, m)
      sort(input, m+1, r)

      //Merge the sorted halves
      merge(input, l, m, r)
    }
    return input
  }

  def merge(input: Array[Int], l: Int, m: Int, r: Int): Unit ={

    //Find the size of the two subarrays to be merged
    val n1 = m-l+1
    val n2 = r-m

    //Create temp arrays
    var L = Array.ofDim[Int](n1)
    var R = Array.ofDim[Int](n2)

    //Copy data to the temp arrays
    for(i<-0 to (n1-1)){
      L(i) = input(l+1)
    }
    for(j<-0 to (n2-1)){
      R(j) = input(m+1+j)
    }

    //merge the temp arrays

    var i = 0
    var j = 0

    var k = l
    while(i<n1 && j<n2){
      if(L(i)<=R(j)){
        input(k)=L(i);
        i+=1
      }else{
        input(k)=R(i)
        j+=1
      }
      k+=1
    }

    //Copy the remaining elements of L if any
    while(i<n1){
      input(k) = L(i)
      i+=1
      k+=1
    }

    //Copy the remaining elements of L if any
    while(j<n2){
      input(k) = R(j)
      j+=1
      k+=1
    }
  }

  // NATIVE BENCHMARK

  def merge(array: Array[Int]): Unit = {
    return  array.sorted
  }

  //QUICKSORT
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

  //SELECTION SORT
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
