package fr.unice.si5.progfine.td1.sort

object ArrayInitializer {

  def initialize(nbArrays:Int): Array[Array[Int]] ={
    val random = scala.util.Random

    var arrays :Array[Array[Int]] = Array.ofDim(nbArrays)

    for (i <- 0 to (nbArrays-1)){
      var arraySize = random.nextInt(15) + 1
      var newArray = Array.ofDim[Int](arraySize)

      for (j <- 0 to (arraySize-1)){
        newArray(j)=random.nextInt(100)
      }

      arrays(i)=newArray
    }
    return arrays
  }
}


