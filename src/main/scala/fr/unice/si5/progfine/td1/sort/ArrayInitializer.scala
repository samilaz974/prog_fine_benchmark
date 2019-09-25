package fr.unice.si5.progfine.td1.sort

object ArrayInitializer {

  /**
   * This function creates an array of 2^(powerlimit+1)*arrayCountPerPower arrays with increasing lenghts
   * @param powerLimit the max exponent for the size of the array (2^powerLimit)
   * @param arrayCountPerPower number of arrays per power
   * @param maxValue limit for numbers in array to be sorted. If equal to 10 we will choose random integers under 10.
   * @return
   */
  def initializePowerArrays(powerLimit:Int, arrayCountPerPower:Int, maxValue:Int): Array[Array[Int]] ={
    val random = scala.util.Random
    var arrays :Array[Array[Int]] = Array.ofDim((powerLimit+1)*arrayCountPerPower)

    for (power <- 0 to powerLimit){
      println("power= "+power)
      var arraySize = math.pow(2,power).asInstanceOf[Int]

      for (i <- 1 to arrayCountPerPower){
        var newArray = Array.ofDim[Int](arraySize)
        for(j <- 0 until arraySize){newArray(j)=random.nextInt(1000)}
        println("i= " + i)
        println(newArray.deep.mkString("\n"))
        arrays(power*i) = newArray
      }
    }
    return arrays
  }

  /**
   * This function creates an array of arrayCount arrays with (2^powerLimit) lengths
   * @param power the max exponent for the size of the array (2^powerLimit)
   * @param arrayCount number of arrays
   * @param maxValue limit for numbers in array to be sorted. If equal to 10 we will choose random integers under 10.
   * @return
   */
  def buildArray(power:Int, arrayCount:Int, maxValue:Int): Array[Array[Int]] ={
    val random = scala.util.Random
    var arrays :Array[Array[Int]] = Array.ofDim(arrayCount)

      //println("power= "+power)
      var arraySize = math.pow(2,power).asInstanceOf[Int]

      for (i <- 0 until arrayCount){
        var newArray = Array.ofDim[Int](arraySize)
        for(j <- 0 until arraySize){newArray(j)=random.nextInt(maxValue)}
        //println("i= " + i)
        //println(newArray.deep.mkString("\n"))
        arrays(i) = newArray
      }

    return arrays
  }
}


