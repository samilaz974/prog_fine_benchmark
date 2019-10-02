package fr.unice.si5.progfine.sort

object CountingSortBenchmark {


  // Complexity O(n+k)  n is the number of items in the array and k is the number of keys (maxValue - minValue of the array)
  // From https://github.com/mypetyak/scala-algorithms/blob/master/sort/countingsort.scala
  def countingSort(a: Array[Int]): Array[Int] = {
    var min = 0
    var max = a.max

    def key(value: Int): Int = {
      return value - min
    }

    val result: Array[Int] = new Array[Int](a.length)

    // Count how many of each key we have
    val count: Array[Int] = new Array[Int](max - min + 1)
    a.foreach( (e: Int) => count(key(e)) += 1)

    // Add preceding counts to compute offset for each key
    for (i <- 1 to (max-min)) {
      count(i) += count(i-1)
    }

    // Assemble results using offset and sorted keys
    for (e <- a.reverseIterator) {
      count(key(e)) -= 1
      result(count(key(e))) = e
    }
    return result
  }
}
