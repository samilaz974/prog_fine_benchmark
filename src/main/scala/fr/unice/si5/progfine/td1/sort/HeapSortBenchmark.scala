package fr.unice.si5.progfine.td1.sort


object HeapSortBenchmark { //Complexity 0(nlog(n))

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

}
