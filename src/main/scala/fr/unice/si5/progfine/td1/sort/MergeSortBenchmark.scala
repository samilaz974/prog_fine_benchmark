package fr.unice.si5.progfine.td1.sort

object MergeSortBenchmark {  //Complexity O(nlog(n))

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

}
